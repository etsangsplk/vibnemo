/*
 * Copyright (c) 2015 Huawei, Inc. and others. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
/* Generated By:JavaCC: Do not edit this line. NEMOparser.java */
package org.opendaylight.nemo.user.vnspacemanager.languagestyle.NEMOParse;

import junit.framework.TestCase;
import org.junit.*;
import org.junit.runner.RunWith;
import org.opendaylight.nemo.user.vnspacemanager.languagestyle.NEMOParse.NEMOparser;

import static org.junit.Assert.*;
import org.opendaylight.nemo.user.vnspacemanager.languagestyle.updateintentlang.UpdateNodeLang;
import org.opendaylight.nemo.user.vnspacemanager.languagestyle.updateintentlang.UpdateConnectionLang;
import org.opendaylight.nemo.user.vnspacemanager.languagestyle.updateintentlang.UpdateFlowLang;
import org.opendaylight.nemo.user.vnspacemanager.languagestyle.updateintentlang.UpdateOperationLang;
import org.opendaylight.nemo.user.vnspacemanager.languagestyle.deleteintentlang.DeleteNodeLang;
import org.opendaylight.nemo.user.vnspacemanager.languagestyle.deleteintentlang.DeleteConnectionLang;
import org.opendaylight.nemo.user.vnspacemanager.languagestyle.deleteintentlang.DeleteFlowLang;
import org.opendaylight.nemo.user.vnspacemanager.languagestyle.deleteintentlang.DeleteOperationLang;
import org.opendaylight.nemo.user.vnspacemanager.languagestyle.Query;
import org.opendaylight.nemo.user.vnspacemanager.languagestyle.NEMOConstants;
import org.opendaylight.nemo.user.vnspacemanager.languagestyle.updateintentlang.UpdateTemplateDefinitionLang;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.nemo.user.tenantmanager.TenantManage;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.common.rev151010.UserId;

import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.io.StringReader;
import java.util.Map;

import static org.mockito.Mockito.*;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberMatcher;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
/**
 * Created by zhangmeng on 2016/1/5.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({NEMOparser.class,SimpleCharStream.class,NEMOparserTokenManager.class})
public class NEMOparserTest extends TestCase {
    private Class<NEMOparser> class1;
    private Class<SimpleCharStream> class2;
    private Class<NEMOparserTokenManager> class3;
    private java.io.InputStream inputStream;
    private java.io.Reader reader;
    private NEMOparser nemOparser;
    private NEMOparserTokenManager nemOparserTokenManager;
    private SimpleCharStream simpleCharStream;
    private Field field_NemoParser_jj_initialized_once; //bool
    private Field field_NemoParser_jj_input_stream; //SimpleCharStream
    private Field field_NemoParser_token_source;//NEMOparserTokenManager
    private Field field_SimpleCharStream_inputStream;  //reader
    private Field field_NEMOparserTokenManager_input_stream; //SimpleCharStream

    @Before
    public void setUp() throws Exception {
        inputStream = mock(InputStream.class);
        reader = mock(Reader.class);
        nemOparserTokenManager = mock(NEMOparserTokenManager.class);
        simpleCharStream = mock(SimpleCharStream.class);

        class1 = NEMOparser.class;
        class2 = SimpleCharStream.class;
        class3 = NEMOparserTokenManager.class;

        field_NemoParser_jj_initialized_once = class1.getDeclaredField("jj_initialized_once");//bool
        field_NemoParser_jj_input_stream = class1.getDeclaredField("jj_input_stream"); //SimpleCharStream
        field_NemoParser_token_source = class1.getDeclaredField("token_source"); //NEMOparserTokenManager
        field_SimpleCharStream_inputStream = class2.getDeclaredField("inputStream"); // reader
        field_NEMOparserTokenManager_input_stream = class3.getDeclaredField("input_stream"); //SimpleCharStream

        field_NemoParser_jj_input_stream.setAccessible(true);
        field_SimpleCharStream_inputStream.setAccessible(true);
        field_NEMOparserTokenManager_input_stream.setAccessible(true);
        field_NemoParser_jj_initialized_once.setAccessible(true);
        field_NemoParser_token_source.setAccessible(true);

        field_NemoParser_jj_initialized_once.set(class1, false);
        field_NEMOparserTokenManager_input_stream.set(class3, null);
        field_SimpleCharStream_inputStream.set(class2, null);
    }
    @After
    public void teardown() throws Exception{
        field_NemoParser_jj_initialized_once.set(class1,false);
        field_NEMOparserTokenManager_input_stream.set(class3,null);
        field_SimpleCharStream_inputStream.set(class2,null);
    }

    @Test
    public void testInit_ReInit() throws Exception{

        nemOparser = new NEMOparser(inputStream);
        field_NemoParser_jj_input_stream.set(nemOparser, simpleCharStream);
        field_NemoParser_token_source.set(nemOparser, nemOparserTokenManager);
        doNothing().when(simpleCharStream).ReInit(any(InputStream.class), any(String.class), any(int.class), any(int.class));
        //doNothing().when(nemOparserTokenManager).ReInit(any(SimpleCharStream.class));
        nemOparser.ReInit(inputStream);
        verify(simpleCharStream).ReInit(inputStream, null, 1, 1);

        field_NemoParser_jj_initialized_once.set(class1, false);
        field_NEMOparserTokenManager_input_stream.set(class3, null);
        field_SimpleCharStream_inputStream.set(class2,null);
        nemOparser = new NEMOparser(reader);
        field_NemoParser_jj_input_stream.set(nemOparser, simpleCharStream);
        doNothing().when(simpleCharStream).ReInit(any(Reader.class), any(int.class), any(int.class));
        nemOparser.ReInit(reader);
        verify(simpleCharStream).ReInit(any(Reader.class), any(int.class), any(int.class));
    }

    @Test
    public void testParseNEMO() throws Exception {

    }

    @Test
    public void testNEMO() throws Exception {

    }

    @Test
    public void testUpdateIntent() throws Exception {

    }

    @Test
    public void testDeleteIntent() throws Exception {

    }

    @Test
    public void testUpdateNode() throws Exception {

    }

    @Test
    public void testUpdateConnection() throws Exception {

    }

    @Test
    public void testUpdateFlow() throws Exception {

    }

    @Test
    public void testUpdateOperation() throws Exception {

    }

    @Test
    public void testNodeModel() throws Exception {
        UserId userId = mock(UserId.class);
        DataBroker dataBroker = mock(DataBroker.class);
        TenantManage tenantManage = mock(TenantManage.class);

        Field field_jj_ntk = class1.getDeclaredField("jj_ntk");
        field_jj_ntk.setAccessible(true);
        Field field_token = class1.getDeclaredField("token");
        field_token.setAccessible(true);

        Token token = new Token();
        Token token_ID = new Token();
        token_ID.kind = NEMOparserConstants.ID;
        token_ID.image = "test";
        Token token_PROPERTY = new Token();
        token_PROPERTY.kind = NEMOparserConstants.PROPERTY;
        Token token_STRING = new Token();
        token_STRING.kind = NEMOparserConstants.STRING;
        token_STRING.image = "test_string";
        Token token_COLON = new Token();
        token_COLON.kind = NEMOparserConstants.COLON;
        Token token_ID1 = new Token();
        token_ID1.kind = NEMOparserConstants.ID;
        token_ID1.image = "test1";
        Token token_SEMICOLON = new Token();
        token_SEMICOLON.kind = NEMOparserConstants.SEMICOLON;
        Token token_NODE = new Token();
        token_NODE.kind = NEMOparserConstants.NODE;


        //connect
        token.next = token_ID;
        token_ID.next = token_PROPERTY;
        token_PROPERTY.next = token_STRING;
        token_STRING.next = token_COLON;
        token_COLON.next = token_ID1;
        token_ID1.next = token_SEMICOLON;
        token_SEMICOLON.next = token_NODE;

        field_jj_ntk.set(class1, NEMOparserConstants.STRING);
        field_token.set(class1, token);
        PowerMockito.spy(NEMOparser.class);
        PowerMockito.when(NEMOparser.class,"jj_ntk")
                .thenReturn(NEMOparserConstants.NODE)
                .thenReturn(NEMOparserConstants.NODE)
                .thenReturn(NEMOparserConstants.SEMICOLON);
        PowerMockito.mockStatic(NEMOparser.class);
        PowerMockito.when(NEMOparser.abstractNode(userId, any(UpdateTemplateDefinitionLang.class))).thenReturn("zhangmeng");
        Assert.assertTrue(NEMOparser.NodeModel(userId, dataBroker, tenantManage) == null);
    }

    @Test
    public void testAbstractNode() throws Exception {
        UpdateTemplateDefinitionLang definition = mock(UpdateTemplateDefinitionLang.class);
        UserId userId = mock(UserId.class);

        Field field_jj_ntk = class1.getDeclaredField("jj_ntk");
        field_jj_ntk.setAccessible(true);
        Field field_token = class1.getDeclaredField("token");
        field_token.setAccessible(true);

        Token token = new Token();
        Token token_ID = new Token();
        token_ID.kind = NEMOparserConstants.ID;
        token_ID.image = "test";
        Token token_TYPE = new Token();
        token_TYPE.kind = NEMOparserConstants.TYPE;
        Token token_ID1 = new Token();
        token_ID1.kind = NEMOparserConstants.ID;
        token_ID1.image = "test1";
        Token token_CONTAIN = new Token();
        token_CONTAIN.kind = NEMOparserConstants.CONTAIN;
        Token token_ID2 = new Token();
        token_ID2.kind = NEMOparserConstants.ID;
        token_ID2.image = "test2";
        Token token_SEMICOLON = new Token();
        token_SEMICOLON.kind = NEMOparserConstants.SEMICOLON;

        //connect
        token.next = token_ID;
        token_ID.next = token_TYPE;
        token_TYPE.next = token_ID1;
        token_ID1.next = token_CONTAIN;
        token_CONTAIN.next = token_ID2;
        token_ID2.next = token_SEMICOLON;

        field_jj_ntk.set(class1, NEMOparserConstants.CONTAIN);
        field_token.set(class1, token);
        Assert.assertTrue(NEMOparser.abstractNode(userId, definition) == null);

        //branch PROPERTY
        //connect aggin
        Token token_PROPERTY = new Token();
        token_PROPERTY.kind = NEMOparserConstants.PROPERTY;
        Token token_COLON = new Token();
        token_COLON.kind = NEMOparserConstants.COLON;
        PowerMockito.mockStatic(NEMOparser.class);
        PowerMockito.when(NEMOparser.property()).thenReturn(new LinkedHashMap<String, String>());
        token.next = token_ID;
        token_ID.next = token_TYPE;
        token_TYPE.next = token_ID1;
        token_ID1.next = token_PROPERTY;
        token_PROPERTY.next = token_ID2;
        token_ID2.next = token_COLON;
        token_COLON.next = token_SEMICOLON;

        field_jj_ntk.set(class1, NEMOparserConstants.PROPERTY);
        field_token.set(class1, token);
        Assert.assertTrue(NEMOparser.abstractNode(userId, definition) == null);

    }

    @Test
    public void testAbstractConnection() throws Exception {
        UserId userId = mock(UserId.class);
        UpdateTemplateDefinitionLang definition = mock(UpdateTemplateDefinitionLang.class);

        Field field_jj_ntk = class1.getDeclaredField("jj_ntk");
        field_jj_ntk.setAccessible(true);
        Field field_token = class1.getDeclaredField("token");
        field_token.setAccessible(true);

        Token token = new Token();
        Token token_ID = new Token();
        token_ID.kind = NEMOparserConstants.ID;
        token_ID.image = "test";
        Token token_TYPE = new Token();
        token_TYPE.kind = NEMOparserConstants.TYPE;
        Token token_ID1 = new Token();
        token_ID1.kind = NEMOparserConstants.ID;
        token_ID1.image = "test1";
        Token token_ENDNODES = new Token()  ;
        token_ENDNODES.kind = NEMOparserConstants.ENDNODES;
        Token token_ID2 = new Token();
        token_ID2.kind = NEMOparserConstants.ID;
        token_ID2.image = "test2";
        Token token_SEMICOLON = new Token();
        token_SEMICOLON.kind = NEMOparserConstants.SEMICOLON;
        //connect
        token.next = token_ID;
        token_ID.next = token_TYPE;
        token_TYPE.next = token_ID1;
        token_ID1.next = token_ENDNODES;
        token_ENDNODES.next = token_ID2;
        token_ID2.next = token_SEMICOLON;

        field_jj_ntk.set(class1, NEMOparserConstants.ENDNODES);
        field_token.set(class1, token);

        Assert.assertTrue(NEMOparser.abstractConnection(userId, definition) == null);

        //branch PROPERTY
        //connect aggin
        Token token_PROPERTY = new Token();
        token_PROPERTY.kind = NEMOparserConstants.PROPERTY;
        Token token_COLON = new Token();
        token_COLON.kind = NEMOparserConstants.COLON;
        PowerMockito.mockStatic(NEMOparser.class);
        PowerMockito.when(NEMOparser.property()).thenReturn(new LinkedHashMap<String, String>());
        token.next = token_ID;
        token_ID.next = token_TYPE;
        token_TYPE.next = token_ID1;
        token_ID1.next = token_PROPERTY;
        token_PROPERTY.next = token_ID2;
        token_ID2.next = token_COLON;
        token_COLON.next = token_SEMICOLON;

        field_jj_ntk.set(class1, NEMOparserConstants.PROPERTY);
        field_token.set(class1, token);
        Assert.assertTrue(NEMOparser.abstractConnection(userId, definition) == null);
    }

    @Test
    public void testAbstractFlow() throws Exception {
        UpdateTemplateDefinitionLang definition = mock(UpdateTemplateDefinitionLang.class);

        Field field_jj_ntk = class1.getDeclaredField("jj_ntk");
        field_jj_ntk.setAccessible(true);
        Field field_token = class1.getDeclaredField("token");
        field_token.setAccessible(true);

        Token token = new Token();
        Token token_ID = new Token();
        token_ID.kind = NEMOparserConstants.ID;
        token_ID.image = "test";
        Token token_MATCH = new Token();
        token_MATCH.kind = NEMOparserConstants.MATCH;
        Token token_ID1 = new Token();
        token_ID1.kind = NEMOparserConstants.ID;
        Token token_COLON = new Token();
        token_COLON.kind = NEMOparserConstants.COLON;
        Token token_PROPERTY = new Token();
        token_PROPERTY.kind = NEMOparserConstants.PROPERTY;
        Token token_ID2 = new Token();
        token_ID2.kind = NEMOparserConstants.ID;
        Token token_COLON1 = new Token();
        token_COLON1.kind = NEMOparserConstants.COLON;
        Token token_SEMICOLON = new Token();
        token_SEMICOLON.kind = NEMOparserConstants.SEMICOLON;
        //connect
        token.next = token_ID;
        token_ID.next = token_MATCH;
        token_MATCH.next = token_ID1;
        token_ID1.next = token_COLON;
        token_COLON.next = token_PROPERTY;
        token_PROPERTY.next = token_ID2;
        token_ID2.next = token_COLON1;
        token_COLON1.next = token_SEMICOLON;

        field_jj_ntk.set(class1, NEMOparserConstants.PROPERTY);
        field_token.set(class1, token);

        PowerMockito.mockStatic(NEMOparser.class);
        PowerMockito.when(NEMOparser.property()).thenReturn(new LinkedHashMap<String, String>());
        when(definition.createAbstractFlow(any(String.class), any(LinkedHashMap.class), any(LinkedHashMap.class))).thenReturn("test");
        Assert.assertTrue(NEMOparser.abstractFlow(definition) == null);

    }

    @Test
    public void testAbstractOperation() throws Exception {
//        NEMOparser.abstractConnection();
    }

    @Test
    public void testDeleteNode() throws Exception {
        UserId userId = mock(UserId.class);
        DataBroker dataBroker = mock(DataBroker.class);
        TenantManage tenantManage = mock(TenantManage.class);

        Field field_token = class1.getDeclaredField("token");
        field_token.setAccessible(true);

        Token token1 = new Token();
        Token token2 = new Token();
        Token token3 = new Token();
        token1.next = token2;
        token1.kind = token2.kind = 56;
        token1.image = token2.image = token3.image = "test";
        token3.kind = 7;

        field_token.set(class1, token1);

        //get into method "jj_consume_token" arg(56)
        //returned token2
        //get into method "jj_consume_token" arg(7) token = token2
        PowerMockito.mockStatic(NEMOparserTokenManager.class);
        PowerMockito.when(NEMOparserTokenManager.getNextToken()).thenReturn(token3);
        //returned token3  token = token3
        //get into method "DeleteOperationHandling" args(userid,0)
        when(tenantManage.getObjectId(userId,"test")).thenReturn(null);
        Assert.assertTrue(NEMOparser.DeleteNode(userId, dataBroker, tenantManage).equals("The node " + "test" + " is not exist."));
    }

    @Test
    public void testDeleteConnection() throws Exception {
        UserId userId = mock(UserId.class);
        DataBroker dataBroker = mock(DataBroker.class);
        TenantManage tenantManage = mock(TenantManage.class);

        Field field_token = class1.getDeclaredField("token");
        field_token.setAccessible(true);

        Token token1 = new Token();
        Token token2 = new Token();
        Token token3 = new Token();
        token1.next = token2;
        token1.kind = token2.kind = 56;
        token1.image = token2.image = token3.image = "test";
        token3.kind = 7;

        field_token.set(class1, token1);

        //get into method "jj_consume_token" arg(56)
        //returned token2
        //get into method "jj_consume_token" arg(7) token = token2
        PowerMockito.mockStatic(NEMOparserTokenManager.class);
        PowerMockito.when(NEMOparserTokenManager.getNextToken()).thenReturn(token3);
        //returned token3  token = token3
        //get into method "DeleteOperationHandling" args(userid,0)
        when(tenantManage.getObjectId(userId,"test")).thenReturn(null);
        Assert.assertTrue(NEMOparser.DeleteConnection(userId, dataBroker, tenantManage).equals("The connection " + "test" + " is not exist."));
    }

    @Test
    public void testDeleteFlow() throws Exception {
        UserId userId = mock(UserId.class);
        DataBroker dataBroker = mock(DataBroker.class);
        TenantManage tenantManage = mock(TenantManage.class);

        Field field_token = class1.getDeclaredField("token");
        field_token.setAccessible(true);

        Token token1 = new Token();
        Token token2 = new Token();
        Token token3 = new Token();
        token1.next = token2;
        token1.kind = token2.kind = 56;
        token1.image = token2.image = token3.image = "test";
        token3.kind = 7;

        field_token.set(class1, token1);

        //get into method "jj_consume_token" arg(56)
        //returned token2
        //get into method "jj_consume_token" arg(7) token = token2
        PowerMockito.mockStatic(NEMOparserTokenManager.class);
        PowerMockito.when(NEMOparserTokenManager.getNextToken()).thenReturn(token3);
        //returned token3  token = token3
        //get into method "DeleteOperationHandling" args(userid,0)
        when(tenantManage.getObjectId(userId,"test")).thenReturn(null);
        Assert.assertTrue(NEMOparser.DeleteFlow(userId, dataBroker, tenantManage).equals("The flow " + "test" + " is not exist."));
    }

    @Test
    public void testDeleteOperation() throws Exception {
        UserId userId = mock(UserId.class);
        DataBroker dataBroker = mock(DataBroker.class);
        TenantManage tenantManage = mock(TenantManage.class);

        Field field_token = class1.getDeclaredField("token");
        field_token.setAccessible(true);

        Token token1 = new Token();
        Token token2 = new Token();
        Token token3 = new Token();
        token1.next = token2;
        token1.kind = token2.kind = 56;
        token1.image = token2.image = token3.image = "test";
        token3.kind = 7;

        field_token.set(class1, token1);

        //get into method "jj_consume_token" arg(56)
        //returned token2
        //get into method "jj_consume_token" arg(7) token = token2
        PowerMockito.mockStatic(NEMOparserTokenManager.class);
        PowerMockito.when(NEMOparserTokenManager.getNextToken()).thenReturn(token3);
        //returned token3  token = token3
        //get into method "DeleteOperationHandling" args(userid,0)
        when(tenantManage.getObjectId(userId,"test")).thenReturn(null);
        Assert.assertTrue(NEMOparser.DeleteOperation(userId, dataBroker, tenantManage).equals("The operation " + "test" + " is not exist."));
    }

    @Test
    public void testQuery() throws Exception {
        UserId userId = mock(UserId.class);
        DataBroker dataBroker = mock(DataBroker.class);
        TenantManage tenantManage = mock(TenantManage.class);

        Field field_jj_ntk = class1.getDeclaredField("jj_ntk");
        field_jj_ntk.setAccessible(true);
        Field field_token = class1.getDeclaredField("token");
        field_token.setAccessible(true);

        Token token1 = new Token();
        Token token2 = new Token();
        Token token3 = new Token();
        token1.next = token2;
        token2.next = token3;
        token3.kind = NEMOparserConstants.SEMICOLON;

        token2.kind = NEMOparserConstants.TYPE;
        token2.image = "1";
        field_token.set(class1,token1);
        field_jj_ntk.set(class1, NEMOparserConstants.TYPE);
        Assert.assertTrue(NEMOparser.Query(userId,dataBroker,tenantManage).equals("The item is not supported."));

        token2.kind = NEMOparserConstants.CONTAIN;
        token2.image = "2";
        field_token.set(class1,token1);
        field_jj_ntk.set(class1, NEMOparserConstants.CONTAIN);
        Assert.assertTrue(NEMOparser.Query(userId,dataBroker,tenantManage).equals("The item is not supported."));

        token2.kind = NEMOparserConstants.PROPERTY;
        token2.image = "2";
        field_token.set(class1,token1);
        field_jj_ntk.set(class1, NEMOparserConstants.PROPERTY);
        Assert.assertTrue(NEMOparser.Query(userId,dataBroker,tenantManage).equals("The item is not supported."));

        token2.kind = NEMOparserConstants.ENDNODES;
        token2.image = "2";
        field_token.set(class1,token1);
        field_jj_ntk.set(class1, NEMOparserConstants.ENDNODES);
        Assert.assertTrue(NEMOparser.Query(userId,dataBroker,tenantManage).equals("The item is not supported."));

        token2.kind = NEMOparserConstants.MATCH;
        token2.image = "2";
        field_token.set(class1,token1);
        field_jj_ntk.set(class1, NEMOparserConstants.MATCH);
        Assert.assertTrue(NEMOparser.Query(userId,dataBroker,tenantManage).equals("The item is not supported."));

        token2.kind = NEMOparserConstants.PRIORITY;
        token2.image = "2";
        field_token.set(class1,token1);
        field_jj_ntk.set(class1, NEMOparserConstants.PRIORITY);
        Assert.assertTrue(NEMOparser.Query(userId,dataBroker,tenantManage).equals("The item is not supported."));

        token2.kind = NEMOparserConstants.TARGET;
        token2.image = "2";
        field_token.set(class1,token1);
        field_jj_ntk.set(class1, NEMOparserConstants.TARGET);
        Assert.assertTrue(NEMOparser.Query(userId,dataBroker,tenantManage).equals("The item is not supported."));

        token2.kind = NEMOparserConstants.CONDITION;
        token2.image = "2";
        field_token.set(class1,token1);
        field_jj_ntk.set(class1, NEMOparserConstants.CONDITION);
        Assert.assertTrue(NEMOparser.Query(userId,dataBroker,tenantManage).equals("The item is not supported."));

        token2.kind = NEMOparserConstants.ACTION;
        token2.image = "2";
        field_token.set(class1,token1);
        field_jj_ntk.set(class1, NEMOparserConstants.ACTION);
        Assert.assertTrue(NEMOparser.Query(userId,dataBroker,tenantManage).equals("The item is not supported."));

        token2.kind = NEMOparserConstants.ID;
        token2.image = "2";
        field_token.set(class1,token1);
        field_jj_ntk.set(class1, NEMOparserConstants.ID);
        Assert.assertTrue(NEMOparser.Query(userId,dataBroker,tenantManage).equals("The item is not supported."));

        token2.kind = NEMOparserConstants.NODES;
        token2.image = "2";
        field_token.set(class1,token1);
        field_jj_ntk.set(class1, NEMOparserConstants.NODES);
        Assert.assertTrue(NEMOparser.Query(userId,dataBroker,tenantManage).equals("The item is not supported."));

        token2.kind = NEMOparserConstants.CONNECTIONS;
        token2.image = "2";
        field_token.set(class1,token1);
        field_jj_ntk.set(class1, NEMOparserConstants.CONNECTIONS);
        Assert.assertTrue(NEMOparser.Query(userId,dataBroker,tenantManage).equals("The item is not supported."));

        token2.kind = NEMOparserConstants.FLOWS;
        token2.image = "2";
        field_token.set(class1,token1);
        field_jj_ntk.set(class1, NEMOparserConstants.FLOWS);
        Assert.assertTrue(NEMOparser.Query(userId,dataBroker,tenantManage).equals("The item is not supported."));

        token2.kind = NEMOparserConstants.OPERATIONS;
        token2.image = "2";
        field_token.set(class1,token1);
        field_jj_ntk.set(class1, NEMOparserConstants.OPERATIONS);
        Assert.assertTrue(NEMOparser.Query(userId,dataBroker,tenantManage).equals("The item is not supported."));
    }

    @Test
    public void testConditionTarget() throws Exception {
        Field field_jj_ntk = class1.getDeclaredField("jj_ntk");
        field_jj_ntk.setAccessible(true);
        Field field_token = class1.getDeclaredField("token");
        field_token.setAccessible(true);

        Token token1 = new Token();
        Token token2 = new Token();
        token1.next = token2;

        token2.kind = NEMOparserConstants.ID;
        token2.image = "1";
        field_token.set(class1,token1);
        field_jj_ntk.set(class1, NEMOparserConstants.ID);
        Assert.assertTrue(NEMOparser.conditionTarget().containsKey("1"));

        token2.kind = NEMOparserConstants.TIMEVAL;
        token2.image = "2";
        field_token.set(class1,token1);
        field_jj_ntk.set(class1, NEMOparserConstants.TIMEVAL);
        Assert.assertTrue(NEMOparser.conditionTarget().containsKey("2"));

        token2.kind = NEMOparserConstants.FULLTIME;
        token2.image = "3";
        field_token.set(class1,token1);
        field_jj_ntk.set(class1, NEMOparserConstants.FULLTIME);
        Assert.assertTrue(NEMOparser.conditionTarget().containsKey("3"));

        token2.kind = NEMOparserConstants.UNUMBER;
        token2.image = "4";
        field_token.set(class1,token1);
        field_jj_ntk.set(class1, NEMOparserConstants.UNUMBER);
        Assert.assertTrue(NEMOparser.conditionTarget().containsKey("4"));

        //test case LPAREN
        Token token = new Token();
        Token token_LPAREN = new Token();
        Token token_UNUMBER = new Token();
        Token token_COMMA = new Token();
        Token token_UNUMBER1 = new Token();
        Token token_RPAREN = new Token();
        //connect tokens
        token.next = token_LPAREN;
        token_LPAREN.next = token_UNUMBER;
        token_UNUMBER.next = token_COMMA;
        token_COMMA.next = token_UNUMBER1;
        token_UNUMBER1.next = token_RPAREN;
        token_RPAREN.next = null;
        //attribute values
        token_LPAREN.kind = NEMOparserConstants.LPAREN;
        token_UNUMBER.kind = token_UNUMBER1.kind = NEMOparserConstants.UNUMBER;
        token_COMMA.kind = NEMOparserConstants.COMMA;
        token_RPAREN.kind = NEMOparserConstants.RPAREN;
        token_UNUMBER.image = "zhangmeng";
        token_UNUMBER.image = "zhangyuanyuan";


        field_token.set(class1,token);
        field_jj_ntk.set(class1, NEMOparserConstants.LPAREN);
        Assert.assertTrue(NEMOparser.conditionTarget().containsValue("range"));

//        PowerMockito.mockStatic(NEMOparserTokenManager.class);
//        PowerMockito.when(NEMOparserTokenManager.getNextToken())
//                .thenReturn()
//                .thenReturn();

    }

    @Test
    public void testProperty() throws Exception {
        Field field_jj_ntk = class1.getDeclaredField("jj_ntk");
        field_jj_ntk.setAccessible(true);
        Field field_token = class1.getDeclaredField("token");
        field_token.setAccessible(true);

        Token token1 = new Token();
        Token token2 = new Token();
        token1.next = token2;

        token2.kind = NEMOparserConstants.ID;
        token2.image = "1";
        field_token.set(class1,token1);
        field_jj_ntk.set(class1, NEMOparserConstants.ID);
        Assert.assertTrue(NEMOparser.property().containsKey("1"));

        token2.kind = NEMOparserConstants.ETHADDR;
        token2.image = "2";
        field_token.set(class1,token1);
        field_jj_ntk.set(class1, NEMOparserConstants.ETHADDR);
        Assert.assertTrue(NEMOparser.property().containsKey("2"));

        token2.kind = NEMOparserConstants.IPV4PREF;
        token2.image = "3";
        field_token.set(class1,token1);
        field_jj_ntk.set(class1, NEMOparserConstants.IPV4PREF);
        Assert.assertTrue(NEMOparser.property().containsKey("3"));

        token2.kind = NEMOparserConstants.IPV4ADDR;
        token2.image = "4";
        field_token.set(class1,token1);
        field_jj_ntk.set(class1, NEMOparserConstants.IPV4ADDR);
        Assert.assertTrue(NEMOparser.property().containsKey("4"));

        token2.kind = NEMOparserConstants.TIMEVAL;
        token2.image = "5";
        field_token.set(class1,token1);
        field_jj_ntk.set(class1, NEMOparserConstants.TIMEVAL);
        Assert.assertTrue(NEMOparser.property().containsKey("5"));

        token2.kind = NEMOparserConstants.FULLTIME;
        token2.image = "6";
        field_token.set(class1,token1);
        field_jj_ntk.set(class1, NEMOparserConstants.FULLTIME);
        Assert.assertTrue(NEMOparser.property().containsKey("6"));

        token2.kind = NEMOparserConstants.TEMPID;
        token2.image = "7";
        field_token.set(class1,token1);
        field_jj_ntk.set(class1, NEMOparserConstants.TEMPID);
        Assert.assertTrue(NEMOparser.property().containsKey("7"));

        token2.kind = NEMOparserConstants.UNUMBER;
        token2.image = "8";
        field_token.set(class1,token1);
        field_jj_ntk.set(class1, NEMOparserConstants.UNUMBER);
        Assert.assertTrue(NEMOparser.property().containsKey("8"));

    }

    @Test
    public void testNodeMultiProperty() throws Exception {

    }

    @Test
    public void testReInit() throws Exception {
        nemOparser = new NEMOparser(nemOparserTokenManager);
        nemOparser.ReInit(nemOparserTokenManager);
    }


    @Test
    public void testGetToken_GetNextToken() throws Exception {
        Field field_token = class1.getDeclaredField("token");
        field_token.setAccessible(true);

        Token token1 = new Token();
        Token token2 = new Token();
        token1.next = token2;

        field_token.set(class1, token1);

        PowerMockito.mockStatic(NEMOparserTokenManager.class);
        PowerMockito.when(NEMOparserTokenManager.getNextToken()).thenReturn(token1);

        Assert.assertTrue(NEMOparser.getToken(2) == token1);
        Assert.assertTrue(NEMOparser.getNextToken() == token2);
        field_token.set(class1, token2);
        Assert.assertTrue(NEMOparser.getNextToken() == token1);
    }

    @Test
    public void testGenerateParseException() throws Exception {
        Field field_jj_kind = class1.getDeclaredField("jj_kind");
        field_jj_kind.setAccessible(true);
        Field field_jj_la1 = class1.getDeclaredField("jj_la1");
        field_jj_la1.setAccessible(true);
        Field field_jj_gen = class1.getDeclaredField("jj_gen");
        field_jj_gen.setAccessible(true);
        Field field_jj_la1_0 = class1.getDeclaredField("jj_la1_0");
        field_jj_la1_0.setAccessible(true);
        Field field_jj_la1_1 = class1.getDeclaredField("jj_la1_1");
        field_jj_la1_1.setAccessible(true);
        Field field_jj_la1_2 = class1.getDeclaredField("jj_la1_2");
        field_jj_la1_2.setAccessible(true);
        Field field_token = class1.getDeclaredField("token");
        field_token.setAccessible(true);

        Token token1 = new Token();
        Token token2 = new Token();
        int jj_la1[] = new int[68];
        int jj_la1_0[] = new int[100];
        int jj_la1_1[] = new int[100];
        int jj_la1_2[] = new int[100];
        Assert.assertTrue(jj_la1_0[1] == 0);
        for (int i = 0;i < 68;i++)
            jj_la1[i] = 0;
        jj_la1[0] = 1;
        jj_la1_0[0] = 1;
        jj_la1_1[0] = 1;
        jj_la1_2[0] = 1;
        token1.next = token2;

        field_jj_kind.set(class1,0);
        field_jj_gen.set(class1,1);
        field_jj_la1.set(class1,jj_la1);
        field_jj_la1_0.set(class1,jj_la1_0);
        field_jj_la1_1.set(class1,jj_la1_1);
        field_jj_la1_2.set(class1,jj_la1_2);
        field_token.set(class1,token1);

        Assert.assertTrue(NEMOparser.generateParseException() != null);
    }

    @Test
    public void testEnable_tracing() throws Exception {
        NEMOparser.enable_tracing();
    }

    @Test
    public void testDisable_tracing() throws Exception {
        NEMOparser.disable_tracing();
    }
}
