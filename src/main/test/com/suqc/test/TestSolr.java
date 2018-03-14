package com.suqc.test;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class TestSolr {
    private HttpSolrServer server = null;
    private String url = "http://192.168.137.150:8080/solr/collection1";
    @Before
    public void before(){
        server = new HttpSolrServer(url);
    }
    @Test
    public void test1() throws Exception{
        SolrInputDocument document = new SolrInputDocument();
        document.addField("id","10001");
        document.addField("name","suqc");
        server.add(document);
        server.commit();
    }
}
