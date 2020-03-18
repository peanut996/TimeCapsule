# TimeCapsule

## 时间胶囊

灵感来自[timepill.net](https://p.timepill.net/)，算是对其采用全新技术的重构

### 技术栈

+ 后端： `springboot` `JPA`
+ 前端： `vue.js` `vuex` `vue-router`

### 项目demo

[时间胶囊](https://godv2ray.online/tomcat/timecapsule)

#### 环境要求

+ maven
+ npm

请自行安装所需要环境依赖
```shell

#下载
git clone https://github.com/peanut996/TimeCapsule.git

#后端
cd TimeCapsule/timecapsule
mvn install #安装maven dependencies

#前端
cd ../timecapsule-web/
npm install #安装依赖
npm run serve 

```


### 注意事项

因为前后端运行在一个服务器上，因此并未开放跨域处理，在使用vue-cli调试的时候请自行解决  
遇到es-lint报`no-console`错误时，请手动修改`node_modules/eslint/lib/rules/no-console.js` line 25为  
`recommended: false`即可  
  
 
现已弃坑，等过段时间使用`Go`或`Rust`重写后端
