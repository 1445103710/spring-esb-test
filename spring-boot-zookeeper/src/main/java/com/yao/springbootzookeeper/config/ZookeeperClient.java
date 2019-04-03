package com.yao.springbootzookeeper.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName: ZookeeperClient
 * @Description: zk客户端
 * @Date: 2019/3/28 10:45
 * @Author fuchangmin
 */
@Component
public class ZookeeperClient {

    private static final Log log = LogFactory.getLog(ZookeeperClient.class);


    /**
     * 节点类型
     */
    public enum NodeTypeEnum {
        /** nodeInfo */
        NODEINFO,
        /** listenerNode */
        LISTENERNODE
    }

    @Resource
    private RegistryCenterProperties registryCenterProperties;


    @Resource
    private CuratorFramework zkClient;

    /**
     * 获取节点信息
     * @param nodeName
     * @param nodeTypeEnum
     */
    public String getData(String nodeName, NodeTypeEnum nodeTypeEnum) throws Exception {
        switch (nodeTypeEnum) {
            case NODEINFO:
                return new String(getNodeData(registryCenterProperties.getNodeInfo() + "/" + nodeName));
            case LISTENERNODE:
                return new String(getNodeData(registryCenterProperties.getListenerNode() + "/" + nodeName));
            default:
                throw new IllegalArgumentException("the nodeTypeEnum can not null");
        }
    }




    /**
     * 创建zk 节点,并设置数据
     * @param nodeName
     * @param nodeData
     * @param nodeTypeEnum
     * @throws Exception
     */
    public void setData(String nodeName, String nodeData, NodeTypeEnum nodeTypeEnum, CreateMode mode) throws Exception {
        switch (nodeTypeEnum) {
            case NODEINFO:
                createNode(registryCenterProperties.getNodeInfo() + "/" + nodeName, nodeData,mode);
                break;
            case LISTENERNODE:
                createNode(registryCenterProperties.getListenerNode() + "/" + nodeName, nodeData,mode);
                break;
            default:
                throw new IllegalArgumentException("the nodeTypeEnum can not null");
        }
    }

    /**
     * 更新节点数据
     * @param nodeName
     * @param nodeData
     * @param nodeTypeEnum
     * @throws Exception
     */
    public void updateData(String nodeName, String nodeData, NodeTypeEnum nodeTypeEnum) {
        switch (nodeTypeEnum) {
            case NODEINFO:
                updateNode(registryCenterProperties.getNodeInfo() + "/" + nodeName, nodeData);
                break;
            case LISTENERNODE:
                updateNode(registryCenterProperties.getListenerNode() + "/" + nodeName, nodeData);
                break;
            default:
                throw new IllegalArgumentException("the nodeTypeEnum can not null");
        }
    }

    /**
     * 删除节点数据
     * @param nodeName
     * @param nodeTypeEnum
     * @throws Exception
     */
    public void deleteNode(String nodeName, NodeTypeEnum nodeTypeEnum) throws Exception {
        switch (nodeTypeEnum) {
            case NODEINFO:
                deleteNode(registryCenterProperties.getNodeInfo() + "/" + nodeName);
                break;
            case LISTENERNODE:
                deleteNode(registryCenterProperties.getListenerNode() + "/" + nodeName);
                break;
            default:
                throw new IllegalArgumentException("the nodeTypeEnum can not null");
        }
    }

    /**
     * 创建节点
     * @param node
     * @param nodeData
     */
    public void createNode(String node, String nodeData, CreateMode mode) throws Exception {
//        try {
//            Stat stat = zkClient.checkExists().forPath(node);
//            if(stat == null){
//                zkClient.create()
//                        .creatingParentContainersIfNeeded().withMode(mode)
//                        .forPath(node, nodeData.getBytes());
//            }
//        } catch (Exception e) {
//            log.error("ZookeeperClient.createNode ==> node: {}, nodeData: {} "+node+" "+nodeData, e);
//        }
        zkClient.create()
                .creatingParentContainersIfNeeded().withMode(mode)
                .forPath(node, nodeData.getBytes());
    }

    /**
     * 更新节点
     * @param node
     * @param nodeData
     */
    private void updateNode(String node, String nodeData) {
        try {
            zkClient.setData().forPath(node, nodeData.getBytes());
        } catch (Exception e) {
            log.error("ZookeeperClient.updateNode ==> node: {}, nodeData: { }"+ node+" "+nodeData, e);
        }
    }

    /**
     * 删除节点
     * @param node
     */
    private void deleteNode(String node) throws Exception {
            zkClient.delete().forPath(node);

    }

    /**
     * 获取节点信息
     * @param node
     * @return
     */
    private byte[] getNodeData(String node) throws Exception {
            return zkClient.getData().forPath(node);
    }


}
