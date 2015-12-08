/*
 * 蘑菇街 Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 *
 * Author: wuya
 * Create Date: 2015年9月14日 上午10:32:59
 */

package com.mogujie.jarvis.rest;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import com.mogujie.jarvis.core.util.ConfigUtils;

/**
 * 启动RestServer
 *
 */
public class JarvisRest {

    static{
        //GrizzlyHttpServer`logger change
        System.setProperty("java.util.logging.manager","org.apache.logging.log4j.jul.LogManager");
    }
    private  static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) throws IOException {
        LOGGER.info("Starting rest server...");

        int port = ConfigUtils.getRestConfig().getInt("rest.http.port", 8080);

        // 控制器注册
        ResourceConfig resourceConfig = new RestResourceConfig();
        URI baseUri = UriBuilder.fromUri("http://" + Inet4Address.getLocalHost().getHostAddress() + "/").port(port).build();
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(baseUri, resourceConfig);
        server.start();

        LOGGER.info("Rest server started.");
    }

}