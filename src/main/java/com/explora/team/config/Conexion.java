package com.explora.team.config;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;
import java.util.Properties;

public class Conexion {

    public OracleDataSource conecta() {
        try {
            OracleDataSource ds = new OracleDataSource();

            Properties props = new Properties();
            props.setProperty("oracle.net.authentication_services","(TCPS)");
            props.setProperty("javax.net.ssl.trustStore",
                    "C:\\instantclient_19_9\\network\\admin\\cwallet.sso");
            props.setProperty("javax.net.ssl.trustStoreType","SSO");
            props.put("javax.net.ssl.keyStore", "C:\\instantclient_19_9\\network\\admin\\cwallet.sso");
            props.setProperty("javax.net.ssl.keyStoreType","SSO");

            ds.setURL("jdbc:oracle:thin:@(description= (address=(protocol=tcps)(port=1522)(host=adb.sa-saopaulo-1.oraclecloud.com))(connect_data=(service_name=wjzobfix378rc23_explora_high.adb.oraclecloud.com))(security=(ssl_server_cert_dn=\"CN=adb.sa-saopaulo-1.oraclecloud.com,OU=Oracle ADB SAOPAULO,O=Oracle Corporation,L=Redwood City,ST=California,C=US\")))"); //dbAlias should match what's in your tnsnames
            ds.setConnectionProperties( props );

            return ds;
        } catch (SQLException e) {
            System.out.println("error: " + e);
            return null;
        }
    }

    public static void main(String[] args) throws SQLException {
        Conexion con = new Conexion();
        con.conecta();
    }
}
