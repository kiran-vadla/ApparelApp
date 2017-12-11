package com.demo.myretail.util;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

/**
 * @author vkiran
 *
 */
public class MongoConnector {

  public static Datastore getMongoDataStore() {

    MongoClient mongoClient = new MongoClient("localhost", 27017);
    Morphia morphia = new Morphia();
    Datastore datastore = morphia.createDatastore(mongoClient, "productdb");
    return datastore;
  }
}