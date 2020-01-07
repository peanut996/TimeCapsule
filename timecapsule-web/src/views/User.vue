<template>
<div class="user-main">
    <userheader></userheader>
    <img class="log-big" src="../assets/logo.png" alt="">
    <h1 class="title">时间胶囊</h1>
    <div class="action">
      <router-link class="Put" to="user-put">
        <span>PUT</span>
        添加
      </router-link>
      <router-link class="Open" to="user-open">
        <span>OPEN</span>
        打开
      </router-link>
    </div>
    <router-view></router-view>
</div>
</template>

<script>
import userheader from '../components/Header.vue'
export default {
  name: 'user',
  components: { userheader }
}
</script>

<style scoped>
h1{
  text-align: center;
 font-size: 28px;
 line-height: 42px;
 padding-bottom: 30px;
 font-weight: normal;
}
body{
  font-family: 'Microsoft YaHei UI','Microsoft YaHei','微软雅黑',"MicrosoftJhengHei", '华文细黑', STHeiti, MingLiu,serif;
}
a{
  text-decoration: none;
}
ul { list-style: none; }
img { border-style: none; }
.user-main{
 width: 400px;
 margin: 50px auto;
}
.log-big{
  width: 400px;
  height: 200px;
  margin-bottom: 10px;
  margin-top: 100px;
}
.title{
  margin-top:40px;
  margin-bottom: 20px;
}
.action {
    padding: 0 40px;
    height: 0px;
    width: 320px;
    margin: 0;
}

.action a {
    display: block;
    color: #333;
    text-align: center;
    font-size: 18px;
}
.action a.Put {
    float: left;
}

.action a.Open {
    float: right;
}

.action a span {
    display: block;
    font-size: 36px;
}
</style>
