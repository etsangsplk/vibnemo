/*
 * Copyright (c) 2016 Huawei, Inc. and others. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.nemo.user.vnspacemanager.structurestyle.updateintent;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.operation.rev151010.action.instance.ParameterValues;
import static org.junit.Assert.*;
import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.nemo.user.tenantmanager.TenantManage;
import org.opendaylight.nemo.user.vnspacemanager.structurestyle.updateintent.GetDefinitions;
import org.opendaylight.nemo.user.vnspacemanager.structurestyle.updateintent.UpdateTemplateDefinition;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.common.rev151010.PropertyName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.object.rev151010.match.item.instance.MatchItemValue;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.common.rev151010.*;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.object.rev151010.property.instance.PropertyValues;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.intent.rev151010.user.intent.template.definitions.TemplateDefinition;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.object.rev151010.connection.definitions.ConnectionDefinition;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.object.rev151010.connection.point.definitions.ConnectionPointDefinition;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.object.rev151010.connection.instance.EndNode;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.object.rev151010.flow.instance.MatchItem;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.object.rev151010.match.item.definitions.MatchItemDefinition;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.object.rev151010.node.definitions.NodeDefinition;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.object.rev151010.node.instance.Property;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.object.rev151010.node.instance.SubNode;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.object.rev151010.property.definitions.PropertyDefinition;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.object.rev151010.property.instance.property.values.StringValue;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.operation.rev151010.action.definitions.ActionDefinition;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.operation.rev151010.condition.instance.ConditionSegment;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.operation.rev151010.condition.parameter.definitions.ConditionParameterDefinition;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.operation.rev151010.operation.instance.Action;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.template.rev151201.template.definition.grouping.AbstractIntents;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.template.rev151201.template.definition.grouping.TemplateParameter;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.template.rev151201.template.definition.grouping._abstract.intents._abstract.objects.AbstractConnection;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.template.rev151201.template.definition.grouping._abstract.intents._abstract.objects.AbstractFlow;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.template.rev151201.template.definition.grouping._abstract.intents._abstract.objects.AbstractNode;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.template.rev151201.template.definition.grouping._abstract.intents._abstract.objects.AbstractConnectionPoint;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.template.rev151201.template.definition.grouping._abstract.intents._abstract.operations.AbstractOperation;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.common.rev151010.ConditionParameterName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.operation.rev151010.condition.instance.condition.segment.ConditionParameterTargetValue;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.common.rev151010.TemplateName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.template.rev151201.template.definition.grouping._abstract.intents.AbstractOperations;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.template.rev151201.template.definition.grouping._abstract.intents.AbstractObjects;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.mockito.Mockito.*;
/**
 * Created by zhangmeng on 2015/12/28.
 */
public class UpdateTemplateDefinitionTest extends TestCase {
    private DataBroker dataBroker;
    private TenantManage tenantManage;
    private UpdateTemplateDefinition updateTemplateDefinition;
    private Class<UpdateTemplateDefinition> class1;
    private Field field;
    private Method method;
    @Before
    public void setUp() throws Exception {
        class1 = UpdateTemplateDefinition.class;
        dataBroker = mock(DataBroker.class);
        tenantManage = mock(TenantManage.class);

        updateTemplateDefinition = new UpdateTemplateDefinition(dataBroker,tenantManage);
    }

    @Test
    public void testCheckTemplateDefinition() throws Exception {
        field = class1.getDeclaredField("getDefinitions");
        field.setAccessible(true);

        UserId userId = mock(UserId.class);
        NodeId nodeId = mock(NodeId.class);
        SubNode subNode = mock(SubNode.class);
        EndNode endNode = mock(EndNode.class);
        MatchItem matchItem = mock(MatchItem.class);
        ObjectId objectId = mock(ObjectId.class);
        AbstractFlow abstractFlow = mock(AbstractFlow.class);
        TemplateName templateName = mock(TemplateName.class);
        ParameterName parameterName = mock(ParameterName.class);
        AbstractOperation abstractOperation = mock(AbstractOperation.class);
        TemplateParameter templateParameter = mock(TemplateParameter.class);
        TemplateDefinition templateDefinition = mock(TemplateDefinition.class);
        AbstractNode abstractNode = mock(AbstractNode.class);
        AbstractIntents abstractIntents = mock(AbstractIntents.class);
        AbstractObjects abstractObjects = mock(AbstractObjects.class);
        AbstractOperations abstractOperations = mock(AbstractOperations.class);
        AbstractConnection abstractConnection = mock(AbstractConnection.class);
        AbstractConnectionPoint abstractConnectionPoint = mock(AbstractConnectionPoint.class);
        GetDefinitions getDefinitions = mock(GetDefinitions.class);
        List<TemplateParameter> list = new ArrayList<TemplateParameter>();
        List<AbstractNode> nodeList = new ArrayList<AbstractNode>();
        List<SubNode> subNodeList = new ArrayList<SubNode>();
        List<AbstractConnection> connectionList = new ArrayList<AbstractConnection>();
        List<EndNode> endNodeList = new ArrayList<EndNode>();
        List<AbstractFlow> flowList = new ArrayList<AbstractFlow>();
        List<MatchItem> matchItemList =  new ArrayList<MatchItem>();
        List<AbstractConnectionPoint> connectionPointList = new ArrayList<AbstractConnectionPoint>();
        List<AbstractOperation> operationList = new ArrayList<AbstractOperation>();
        Map<TemplateName, TemplateDefinition> map = mock(Map.class);
        Map<NodeType, NodeDefinition> nodeDefinitions = mock(Map.class);
        Map<MatchItemName, MatchItemDefinition> matchItemDefinitionMap = mock(Map.class);

        list.add(templateParameter);
        nodeList.add(abstractNode);
        subNodeList.add(subNode);
        endNodeList.add(endNode);
        connectionList.add(abstractConnection);
        flowList.add(abstractFlow);
        matchItemList.add(matchItem);
        connectionPointList.add(abstractConnectionPoint);
        operationList.add(abstractOperation);

        when(tenantManage.getTempalteDefinition(userId))
                .thenReturn(map)
                .thenReturn(map)
                .thenReturn(null);
        when(templateDefinition.getTemplateName()).thenReturn(templateName);
        when(map.containsKey(templateDefinition.getTemplateName())).thenReturn(true);
        Assert.assertTrue(updateTemplateDefinition.checkTemplateDefinition(userId, templateDefinition).equals("The template " + templateDefinition.getTemplateName().getValue() + " has been defined."));
        verify(tenantManage, times(2)).getTempalteDefinition(userId);

        when(templateDefinition.getTemplateParameter()).thenReturn(list);
        when(templateParameter.getParameterName()).thenReturn(parameterName);
        when(templateParameter.getParameterValueType()).thenReturn(TemplateParameter.ParameterValueType.Int);
        when(templateDefinition.getAbstractIntents()).thenReturn(abstractIntents);
//        when(abstractIntents.getAbstractOperations())
//                .thenReturn(null);
        when(abstractIntents.getAbstractObjects()).thenReturn(abstractObjects);
        when(abstractObjects.getAbstractNode())
                .thenReturn(nodeList) //1
                .thenReturn(nodeList) //1
                .thenReturn(nodeList) //1
                .thenReturn(nodeList) //1
                .thenReturn(null) //1
                .thenReturn(nodeList)//2
                .thenReturn(nodeList)//2
                .thenReturn(null)//1
                .thenReturn(null)//2
                .thenReturn(null)//1
                .thenReturn(null)//1
                .thenReturn(null)//1
                .thenReturn(nodeList)//3
                .thenReturn(nodeList);//3
        when(abstractNode.getNodeId()).thenReturn(nodeId);
        when(abstractNode.getSubNode())
                .thenReturn(subNodeList)
                .thenReturn(subNodeList)
                .thenReturn(null);
        when(subNode.getNodeId()).thenReturn(null);
        Assert.assertTrue(updateTemplateDefinition.checkTemplateDefinition(userId, templateDefinition).equals("The sub node is not defined."));
        verify(abstractNode,times(2)).getSubNode();
        verify(abstractObjects,times(2)).getAbstractNode();
        //get into method "checkNodeTemplate" args(abstractNode,map)
        field.set(updateTemplateDefinition, getDefinitions);
        when(abstractNode.getNodeType()).thenReturn(mock(NodeType.class));
        when(getDefinitions.getNodeDefinition()).thenReturn(nodeDefinitions);
        when(nodeDefinitions.containsKey(any(NodeType.class))).thenReturn(false);
        Assert.assertTrue(updateTemplateDefinition.checkTemplateDefinition(userId, templateDefinition).equals("The node type " + abstractNode.getNodeType().getValue() + " is not defined."));
        verify(abstractNode,times(3)).getSubNode();
        verify(abstractObjects, times(4)).getAbstractNode();

        when(abstractObjects.getAbstractConnection())
                .thenReturn(connectionList)//1
                .thenReturn(connectionList)//1
                .thenReturn(connectionList)//1
                .thenReturn(connectionList)//1
                .thenReturn(null)//1
                .thenReturn(null)//1
                .thenReturn(null)//1
                .thenReturn(connectionList)//2
                .thenReturn(connectionList);//2
        when(abstractConnection.getEndNode()).thenReturn(endNodeList);
        when(endNode.getNodeId()).thenReturn(null);
        Assert.assertTrue(updateTemplateDefinition.checkTemplateDefinition(userId, templateDefinition).equals("The end node is not exist."));
        verify(abstractObjects,times(7)).getAbstractNode();
        verify(abstractObjects,times(2)).getAbstractConnection();
//        Assert.assertTrue(updateTemplateDefinition.checkTemplateDefinition(userId, templateDefinition).equals("The end node is not exist."));
        Assert.assertTrue(updateTemplateDefinition.checkTemplateDefinition(userId, templateDefinition).equals("There are no end nodes exist."));
        verify(abstractObjects, times(9)).getAbstractNode();
        verify(abstractObjects, times(4)).getAbstractConnection();

        when(abstractObjects.getAbstractFlow())
                .thenReturn(flowList)//1
                .thenReturn(flowList)//1
                .thenReturn(null)//1
                .thenReturn(null)//1
                .thenReturn(flowList)//2
                .thenReturn(flowList);//2
        //get into method "checkFlowTemplate" args(abstractFlow,map)
        when(getDefinitions.getMatchItemDefinition()).thenReturn(matchItemDefinitionMap);
        when(abstractFlow.getMatchItem()).thenReturn(matchItemList);
        when(matchItem.getMatchItemName()).thenReturn(mock(MatchItemName.class));
        when(matchItemDefinitionMap.containsKey(any(MatchItemName.class))).thenReturn(false);
        Assert.assertTrue(updateTemplateDefinition.checkTemplateDefinition(userId, templateDefinition).equals("The match item " + matchItem.getMatchItemName().getValue() + " is not defined."));
        verify(abstractObjects, times(10)).getAbstractNode();
        verify(abstractObjects, times(5)).getAbstractConnection();
        verify(abstractObjects, times(2)).getAbstractFlow();

        when(abstractObjects.getAbstractConnectionPoint())
                .thenReturn(connectionPointList)//1
                .thenReturn(connectionPointList)//1
                .thenReturn(null);//1
        verify(abstractObjects, times(11)).getAbstractNode();
        verify(abstractObjects, times(6)).getAbstractConnection();//aqui ahora es connectionPoint
        verify(abstractObjects, times(3)).getAbstractFlow();
        verify(abstractObjects, times(2)).getAbstractConnectionPoint();
                
        when(abstractIntents.getAbstractOperations()).thenReturn(abstractOperations);
        when(abstractOperations.getAbstractOperation())
                .thenReturn(operationList)
                .thenReturn(operationList)
                .thenReturn(null);
        when(abstractOperation.getTargetObject()).thenReturn(objectId);
        Assert.assertTrue(updateTemplateDefinition.checkTemplateDefinition(userId, templateDefinition).equals("The target is not exist."));
//        System.out.println(updateTemplateDefinition.checkTemplateDefinition(userId, templateDefinition) + "dfsfsdfsfds");
        verify(abstractObjects, times(14)).getAbstractNode();
        verify(abstractObjects, times(8)).getAbstractConnection();
        verify(abstractObjects, times(6)).getAbstractFlow();
        verify(abstractObjects, times(3)).getAbstractConnectionPoint();


    }

    @Test
    public void testCheckNodeTemplate() throws Exception{
        method = class1.getDeclaredMethod("checkNodeTemplate",new Class[]{
                AbstractNode.class,
                Map.class
        });
        method.setAccessible(true);
        field = class1.getDeclaredField("getDefinitions");
        field.setAccessible(true);

        GetDefinitions getDefinitions = mock(GetDefinitions.class);
        AbstractNode node = mock(AbstractNode.class);
        NodeType nodeType = mock(NodeType.class);
        NodeDefinition nodeDefinition = mock(NodeDefinition.class);
        PropertyName propertyName = mock(PropertyName.class);
        Property property = mock(Property.class);
        StringValue stringValue = mock(StringValue.class);
        PropertyValues propertyValues = mock(PropertyValues.class);
        PropertyDefinition.PropertyValueType type = PropertyDefinition.PropertyValueType.String;
        PropertyDefinition propertyDefinition = mock(PropertyDefinition.class);
        TemplateParameter.ParameterValueType valueType = TemplateParameter.ParameterValueType.Int;
        List<Property> properties = new ArrayList<Property>();
        List<StringValue> stringValues = new ArrayList<StringValue>();
        List<PropertyDefinition> propertyDefinitions = new ArrayList<PropertyDefinition>();
        Map<ParameterName, TemplateParameter.ParameterValueType> parameterValueTypeMap = new HashMap<ParameterName, TemplateParameter.ParameterValueType>();
        Map<NodeType, NodeDefinition> nodeDefinitions = new HashMap<NodeType, NodeDefinition>();

        parameterValueTypeMap.put(new ParameterName("ParameterName"),valueType);

        field.set(updateTemplateDefinition, getDefinitions);
        when(getDefinitions.getNodeDefinition()).thenReturn(nodeDefinitions);
        when(node.getNodeType()).thenReturn(nodeType);
        when(nodeType.getValue()).thenReturn("test");
        //test null
        Assert.assertTrue(method.invoke(updateTemplateDefinition,node,parameterValueTypeMap).equals("The node type " + node.getNodeType().getValue() + " is not defined."));
        verify(node,times(3)).getNodeType();
        //test not null
        nodeDefinitions.put(nodeType, nodeDefinition);
        propertyDefinitions.add(propertyDefinition);
        properties.add(property);
        stringValues.add(stringValue);
        Assert.assertTrue(nodeDefinitions.get(nodeType) == nodeDefinition);
        when(nodeDefinition.getPropertyDefinition()).thenReturn(propertyDefinitions);
        when(propertyDefinition.getPropertyName()).thenReturn(propertyName);
        when(propertyName.getValue()).thenReturn("test");
        when(node.getProperty())
                .thenReturn(null)
                .thenReturn(properties);
        Assert.assertTrue(method.invoke(updateTemplateDefinition, node, parameterValueTypeMap) == null);
        when(property.getPropertyName())
                .thenReturn(mock(PropertyName.class))
                .thenReturn(propertyName);
        Assert.assertTrue(method.invoke(updateTemplateDefinition, node, parameterValueTypeMap).equals("The property name " + property.getPropertyName().getValue() + " is not defined."));
        when(propertyDefinition.getPropertyValueType())
                .thenReturn(PropertyDefinition.PropertyValueType.Int)
                .thenReturn(type);
//        System.out.println("type" + type.getIntValue());
        Assert.assertTrue(method.invoke(updateTemplateDefinition, node, parameterValueTypeMap) == null);
        when(property.getPropertyValues()).thenReturn(propertyValues);
        when(propertyValues.getStringValue()).thenReturn(stringValues);
        when(stringValue.getValue()).thenReturn(new String("ParameterName"));
        Assert.assertTrue(method.invoke(updateTemplateDefinition, node, parameterValueTypeMap).equals("The property " + property.getPropertyName().getValue() + " type is not right."));

    }

    @Test
    public void testCheckConnectionTemplate() throws Exception{
        method = class1.getDeclaredMethod("checkConnectionTemplate", new Class[]{
                AbstractConnection.class,
                Map.class
        });
        method.setAccessible(true);
        field = class1.getDeclaredField("getDefinitions");
        field.setAccessible(true);

        GetDefinitions getDefinitions = mock(GetDefinitions.class);
        AbstractConnection connection = mock(AbstractConnection.class);
        ConnectionDefinition connectionDefinition = mock(ConnectionDefinition.class);
        ConnectionType connectionType = mock(ConnectionType.class);
        PropertyDefinition propertyDefinition = mock(PropertyDefinition.class);
        PropertyName propertyName = mock(PropertyName.class);
        PropertyValues propertyValues = mock(PropertyValues.class);
        StringValue stringValue = mock(StringValue.class);
        PropertyDefinition.PropertyValueType type = PropertyDefinition.PropertyValueType.String;
        TemplateParameter.ParameterValueType valueType = TemplateParameter.ParameterValueType.Int;
        org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.object.rev151010.connection.instance.Property
                property = mock(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.object.rev151010.connection.instance.Property.class);
        List<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.object.rev151010.connection.instance.Property>
                properties = new ArrayList<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.object.rev151010.connection.instance.Property>();
        List<PropertyDefinition> propertyDefinitions = new ArrayList<PropertyDefinition>();
        List<StringValue> stringValues = new ArrayList<StringValue>();
        Map<ParameterName, TemplateParameter.ParameterValueType> parameterValueTypeMap = new HashMap<ParameterName, TemplateParameter.ParameterValueType>();
        Map<ConnectionType, ConnectionDefinition> connDefinitions = new HashMap<ConnectionType, ConnectionDefinition>();

        field.set(updateTemplateDefinition, getDefinitions);
        propertyDefinitions.add(propertyDefinition);
        properties.add(property);
        stringValues.add(stringValue);
        parameterValueTypeMap.put(new ParameterName("ParameterName"), valueType);

        when(getDefinitions.getConnectionDefinition()).thenReturn(connDefinitions);
        when(connection.getConnectionType()).thenReturn(connectionType);
        when(connectionType.getValue()).thenReturn("test");
        //test null
        Assert.assertTrue(method.invoke(updateTemplateDefinition, connection, parameterValueTypeMap).equals("The connection type " + connection.getConnectionType().getValue() + " is not defined."));
        //test not null
        connDefinitions.put(connectionType, connectionDefinition);
        when(connectionDefinition.getPropertyDefinition()).thenReturn(propertyDefinitions);
        when(propertyDefinition.getPropertyName()).thenReturn(propertyName);
        when(connection.getProperty())
                .thenReturn(null)
                .thenReturn(properties);
        Assert.assertTrue(method.invoke(updateTemplateDefinition, connection, parameterValueTypeMap) == null);
        when(property.getPropertyName())
                .thenReturn(mock(PropertyName.class))
                .thenReturn(propertyName);
        when(propertyName.getValue()).thenReturn("test");
        Assert.assertTrue(method.invoke(updateTemplateDefinition, connection, parameterValueTypeMap).equals("The property name " + property.getPropertyName().getValue() + " is not defined."));
        Assert.assertTrue(type.getIntValue() == 0);
        when(propertyDefinition.getPropertyValueType())
                .thenReturn(PropertyDefinition.PropertyValueType.Int)
                .thenReturn(type);
        Assert.assertTrue(method.invoke(updateTemplateDefinition, connection, parameterValueTypeMap) == null);
        verify(propertyDefinition).getPropertyValueType();
        when(property.getPropertyValues()).thenReturn(propertyValues);
        when(propertyValues.getStringValue()).thenReturn(stringValues);
        when(stringValue.getValue()).thenReturn(new String("ParameterName"));
        Assert.assertTrue(parameterValueTypeMap.get(new ParameterName("ParameterName")) == valueType);
//        System.out.println((String) method.invoke(updateTemplateDefinition, connection, parameterValueTypeMap));
//        System.out.println("valuetype" + valueType.getIntValue());
        Assert.assertTrue(method.invoke(updateTemplateDefinition, connection, parameterValueTypeMap).equals("The property " + property.getPropertyName().getValue() + " type is not right."));
        verify(stringValue).getValue();
    }

    @Test
    public void testCheckFlowTemplate() throws Exception{
        method = class1.getDeclaredMethod("checkFlowTemplate",new Class[]{
                AbstractFlow.class,
                Map.class
        });
        method.setAccessible(true);
        field = class1.getDeclaredField("getDefinitions");
        field.setAccessible(true);

        GetDefinitions getDefinitions = mock(GetDefinitions.class);
        AbstractFlow flow = mock(AbstractFlow.class);
        MatchItem matchItem = mock(MatchItem.class);
        List<MatchItem> matchItemList = new ArrayList<MatchItem>();
        MatchItemValue matchItemValue = mock(MatchItemValue.class);
        MatchItemName matchItemName = mock(MatchItemName.class);
        MatchItemDefinition matchItemDefinition = mock(MatchItemDefinition.class);
        MatchItemDefinition.MatchItemValueType type = MatchItemDefinition.MatchItemValueType.String;
        TemplateParameter.ParameterValueType valueType = TemplateParameter.ParameterValueType.Int;
        Map<MatchItemName, MatchItemDefinition> matchItemDefinitionMap = new HashMap<MatchItemName, MatchItemDefinition>();
        Map<ParameterName, TemplateParameter.ParameterValueType> parameterValueTypeMap = new HashMap<ParameterName, TemplateParameter.ParameterValueType>();

        field.set(updateTemplateDefinition, getDefinitions);
        parameterValueTypeMap.put(new ParameterName("ParameterName"),valueType);

        when(getDefinitions.getMatchItemDefinition()).thenReturn(matchItemDefinitionMap);
        when(flow.getMatchItem()).thenReturn(matchItemList);
        Assert.assertTrue(method.invoke(updateTemplateDefinition, flow, parameterValueTypeMap) == null);
        matchItemList.add(matchItem);
        when(matchItem.getMatchItemName()).thenReturn(matchItemName);
        when(matchItemName.getValue()).thenReturn("test");
        Assert.assertTrue(method.invoke(updateTemplateDefinition, flow, parameterValueTypeMap).equals("The match item " + matchItem.getMatchItemName().getValue() +" is not defined."));
        //test add matchItem
        matchItemDefinitionMap.put(matchItemName,matchItemDefinition);
        Assert.assertTrue(matchItemDefinitionMap.containsKey(matchItemName));
        when(matchItemDefinition.getMatchItemValueType())
                .thenReturn(MatchItemDefinition.MatchItemValueType.Int)
                .thenReturn(type);
        Assert.assertTrue(method.invoke(updateTemplateDefinition, flow, parameterValueTypeMap) == null);
        when(matchItem.getMatchItemValue()).thenReturn(matchItemValue);
        when(matchItemValue.getStringValue()).thenReturn("ParameterName");
        Assert.assertTrue(method.invoke(updateTemplateDefinition, flow, parameterValueTypeMap).equals("The match item " + "ParameterName" +" type is not right."));

    }

    @Test
    public void testCheckOperationTemplate() throws Exception{
        method = class1.getDeclaredMethod("checkOperationTemplate",new Class[]{
                AbstractOperation.class,
                Map.class
        });
        method.setAccessible(true);
        field = class1.getDeclaredField("getDefinitions");
        field.setAccessible(true);

        GetDefinitions getDefinitions = mock(GetDefinitions.class);
        Action action = mock(Action.class);
        ActionName actionName = mock(ActionName.class);
        ActionDefinition actionDefinition = mock(ActionDefinition.class);
        AbstractOperation operation = mock(AbstractOperation.class);
        ConditionSegment conditionSegment = mock(ConditionSegment.class);
        ParameterName parameterName = mock(ParameterName.class);
        ParameterValues parameterValues = mock(ParameterValues.class);
        ConditionParameterName conditionParameterName = mock(ConditionParameterName.class);
        ConditionParameterDefinition definition = mock(ConditionParameterDefinition.class);
        ConditionParameterDefinition conditionParameterDefinition = mock(ConditionParameterDefinition.class);
        ConditionParameterTargetValue conditionParameterTargetValue = mock(ConditionParameterTargetValue.class);
        ConditionParameterDefinition.ParameterValueType type = ConditionParameterDefinition.ParameterValueType.String;
        TemplateParameter.ParameterValueType valueType = TemplateParameter.ParameterValueType.Int;
        ActionDefinition.ParameterValueType type1 = ActionDefinition.ParameterValueType.String;
        org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.operation.rev151010.action.instance.parameter.values.StringValue
                stringValue = mock(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.operation.rev151010.action.instance.parameter.values.StringValue.class);
        List<Action> actionList = new ArrayList<Action>();
        List<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.operation.rev151010.action.instance.parameter.values.StringValue>
                stringValues = new ArrayList<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.nemo.operation.rev151010.action.instance.parameter.values.StringValue>();
        List<ConditionSegment> conditionSegmentList = new ArrayList<ConditionSegment>();
        Map<ParameterName, TemplateParameter.ParameterValueType> parameterValueTypeMap = new HashMap<ParameterName, TemplateParameter.ParameterValueType>();
        Map<ActionName, ActionDefinition> actionDefinitionMap = new HashMap<ActionName, ActionDefinition>();
        Map<ParameterName, ConditionParameterDefinition> conditionParameterDefinitionMap = mock(Map.class);

        field.set(updateTemplateDefinition, getDefinitions);
        conditionSegmentList.add(conditionSegment);
        parameterValueTypeMap.put(new ParameterName("ParameterName"), valueType);
        conditionParameterDefinitionMap.put(parameterName, conditionParameterDefinition);

        when(getDefinitions.getActionDefinition()).thenReturn(actionDefinitionMap);
        when(getDefinitions.getConditionParameterDefinition()).thenReturn(conditionParameterDefinitionMap);
        when(operation.getConditionSegment())
                .thenReturn(null)
                .thenReturn(conditionSegmentList);
        when(operation.getAction())
                .thenReturn(null)
                .thenReturn(actionList);
        Assert.assertTrue(method.invoke(updateTemplateDefinition, operation, parameterValueTypeMap) == null);
        //test condition
        when(conditionSegment.getConditionParameterName())
                .thenReturn(conditionParameterName);
        when(conditionParameterDefinitionMap.containsKey(conditionSegment.getConditionParameterName()))
                .thenReturn(false)
                .thenReturn(true);
        when(parameterName.getValue()).thenReturn("test");
        Assert.assertTrue(method.invoke(updateTemplateDefinition, operation, parameterValueTypeMap).equals("The Condition " + conditionSegment.getConditionParameterName().getValue() + " is not defined."));
        when(conditionSegment.getConditionParameterTargetValue())
                .thenReturn(null)
                .thenReturn(conditionParameterTargetValue);
        Assert.assertTrue(method.invoke(updateTemplateDefinition, operation, parameterValueTypeMap) == null);
        when(conditionParameterDefinitionMap.get(conditionSegment.getConditionParameterName())).thenReturn(definition);
        when(definition.getParameterValueType())
                .thenReturn(ConditionParameterDefinition.ParameterValueType.Int)
                .thenReturn(type);
        Assert.assertTrue(method.invoke(updateTemplateDefinition, operation, parameterValueTypeMap) == null);
        when(conditionParameterTargetValue.getStringValue()).thenReturn("ParameterName");
        Assert.assertTrue(method.invoke(updateTemplateDefinition, operation, parameterValueTypeMap).equals("The condition " + conditionSegment.getConditionParameterName().getValue() + " type is not right."));

        //test action
        conditionSegmentList.clear();
        actionList.add(action);
        stringValues.add(stringValue);

        when(action.getActionName()).thenReturn(actionName);
        when(actionName.getValue()).thenReturn("test");
        Assert.assertTrue(method.invoke(updateTemplateDefinition, operation, parameterValueTypeMap).equals("The action " + action.getActionName().getValue() + " is not defined."));
        actionDefinitionMap.put(actionName, actionDefinition);
        when(action.getParameterValues())
                .thenReturn(null)
                .thenReturn(parameterValues);
        Assert.assertTrue(method.invoke(updateTemplateDefinition, operation, parameterValueTypeMap) == null);
        when(actionDefinition.getParameterValueType()).thenReturn(type1);
        when(parameterValues.getStringValue()).thenReturn(stringValues);
        when(stringValue.getValue()).thenReturn("ParameterName");
        Assert.assertTrue(method.invoke(updateTemplateDefinition, operation, parameterValueTypeMap).equals("The action " + action.getActionName().getValue() +" type is not right."));
    }
}
