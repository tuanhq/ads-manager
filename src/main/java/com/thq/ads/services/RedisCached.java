package com.thq.ads.services;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

import java.time.Duration;

public class RedisCached {

	private JedisPoolConfig poolConfig = null ;
	private JedisPool jedisPool = null;
	private static final String START_VALUE = "1000";
	private String prefix;

	public RedisCached() {
		this(Protocol.DEFAULT_HOST,Protocol.DEFAULT_PORT,"_");
	}
	public RedisCached(String host,int port,String prefix) {
		poolConfig = buildPoolConfig();
		jedisPool = new JedisPool(poolConfig, host,port);
		this.prefix = prefix;
	}
	@SuppressWarnings("deprecation")
	private  JedisPoolConfig buildPoolConfig() {
		final JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(128);
		poolConfig.setMaxIdle(128);
		poolConfig.setMinIdle(16);
		poolConfig.setTestOnBorrow(true);
		poolConfig.setTestOnReturn(true);
		poolConfig.setTestWhileIdle(true);
		poolConfig.setMinEvictableIdleTimeMillis(Duration.ofSeconds(60).toMillis());
		poolConfig.setTimeBetweenEvictionRunsMillis(Duration.ofSeconds(30).toMillis());
		poolConfig.setNumTestsPerEvictionRun(3);
		poolConfig.setBlockWhenExhausted(true);
		return poolConfig;
	}


	public void put(String key, Object value, int period)  {
		if(period>0) {
			try (Jedis jedis = jedisPool.getResource()) {
				jedis.setex((prefix+key).getBytes(), period, SerializationObjectUtils.serialize(value));
			}
		}else {
			try (Jedis jedis = jedisPool.getResource()) {
				jedis.set((prefix+key).getBytes(), SerializationObjectUtils.serialize(value));
			}
		}

	}


	public void remove(String key) {
		try (Jedis jedis = jedisPool.getResource()) {
			jedis.del((prefix+key));
		}

	}


	public Object get(String key) {
		try (Jedis jedis = jedisPool.getResource()) {
			return SerializationObjectUtils.deserialize(jedis.get((prefix+key).getBytes()));
		}
	}
	public void putString(String key, String value) {
		try (Jedis jedis = jedisPool.getResource()) {
			jedis.set((prefix+key), value);
		}
	}
	public String getString(String key) {
		try (Jedis jedis = jedisPool.getResource()) {
			return jedis.get((prefix+key));
		}
	}


	public void cleanup() {
		try (Jedis jedis = jedisPool.getResource()) {
			jedis.flushAll();
		}

	}


	public long size() {
		// TODO Auto-generated method stub
		return 0;

	}
	public long increment(String key) {

		try (Jedis jedis = jedisPool.getResource()) {
			if(!jedis.exists(prefix+key)) {
				jedis.set(prefix+key, START_VALUE);
				return Long.valueOf(START_VALUE);
			}else {
				return jedis.incr((prefix+key));
			}

		}
	}

	public static void main(String[] args) throws Exception {


	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}

