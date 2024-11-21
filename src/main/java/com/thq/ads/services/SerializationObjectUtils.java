package com.thq.ads.services;


import java.io.*;

public class SerializationObjectUtils {
	public static byte[] serialize(Object obj) {
		if (obj == null) {
			return null;
		}
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
		try {
			ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
			oos.writeObject(obj);
			oos.flush();
		}
		catch (IOException ex) {
			throw new IllegalArgumentException("Failed to serialize object of type: " + obj.getClass(), ex);
		}
		return byteArrayOutputStream.toByteArray();
	}


	public static Object deserialize(byte[] bytes) {
		if (bytes == null) {
			return null;
		}
		try {
			ObjectInputStream objInputStream = new ObjectInputStream(new ByteArrayInputStream(bytes));
			return objInputStream.readObject();
		}
		catch (IOException ex) {
			throw new IllegalArgumentException("Failed to deserialize object", ex);
		}
		catch (ClassNotFoundException ex) {
			throw new IllegalStateException("Failed to deserialize object type", ex);
		}
	}
}
