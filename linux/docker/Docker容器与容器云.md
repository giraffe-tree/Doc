# Docker 容器与容器云

## 参考

1. Docker 容器与容器云  --   浙大 SEL 实验室

# 第一章 从容器到容器云

## 1.1 云计算平台

云计算是一种资源的服务模式,该模式可以实现随时随地,便捷按需地从可配置计算资源共享池中获取所需的资源(如网络,服务器,存储,应用及服务),资源能够快速供应并释放,大大减少了资源管理工作开销.

## 1.2 容器,新的革命

docker 是以 docker 容器为资源分割和调度的基本单位.

docker 可在容器内部快速自动化地部署应用,并通过操作系统内核技术 namespaces,cgroups 为容器提供资源隔离与安全保障.

### 容器技术

容器技术的生态系统覆盖了 iaas,paas 层所涉及的各类问题,包括资源调度,编排,部署,监控,配置管理,存储网络管理,安全等

1. 持续部署与测试
2. 跨云平台支持
3. 环境标准化和版本控制
4. 高资源利用率与隔离
5. 容器跨平台性和镜像
6. 易于理解且易用
7. 应用镜像仓库

# 第二章  docker 基础

## 2.2 docker 操作参数解读

|docker命令分类|子命令|
|-|-|
|环境| info,version|
| 容器生命周期管理 | create,exec,kill,pause,restart,rm,run,start,stop,unpause |
| 镜像仓库命令 | login,logout,pull,push,search |
| 镜像管理 | build,images,inport,load,rmi,save,tag,commit |
| 容器运维操作 | attach,export,inspect,port,ps,rename,stats,top,wait,cp,diff,update |
| 容器资源管理 | volume,network |
| 系统日志信息 | events,history,logs |

















