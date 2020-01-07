<template>
    <div class="header">
        <div class="container">
        <router-link class="logo"  to="/">时间胶囊</router-link>
        <div class="nav">
            <ul>
                <li><router-link  class="nav-item" active-class="is-active" to="/user">首页</router-link ><li>
                <li v-if="!this.$parent.$parent.islogin"><router-link  class="nav-item" active-class="is-active" to="/user-login">登录</router-link ><li>
                <li v-if="!this.$parent.$parent.isregister"><router-link  class="nav-item" active-class="is-active" to="/user-register">注册</router-link ><li>
                <li v-if="this.$parent.$parent.islogin"><router-link  class="nav-item" active-class="is-active" to="/user-profile">用户</router-link ><li>
                <li><router-link class="nav-item" active-class="is-active" to="/user-put">添加</router-link></li>
                <li><router-link  class="nav-item" active-class="is-active" to="/user-open">打开</router-link ></li>
            </ul>
        </div>
        </div>
        <router-view></router-view>
    </div>
</template>

<script>
export default {
  name: 'userheader',
  data: function () {
    return {
      NavName: '登录'
    }
  },
  methods: {
    getActiveName: function () {
      alert(this.$route.params.id)
      this.ActiveName = this.$route.params.id
    }
  }
}
</script>

<style scoped>
a{ text-decoration: none;}
.header{
    height: 38px;
    background-color: #FAFAFA;
    background-image: linear-gradient(to bottom, #FFFFFF, #F2F2F2);
    background: -webkit-linear-gradient(#FFFFFF,#F2F2F2);
    opacity: 0.99;
    border-bottom: 1px solid #d3d3d3;
    color: #777;
    font-size: 14px;
    margin-bottom: 60px;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    z-index: 1000;
    box-shadow: 0 0 5px #ccc;
    font-weight: bold;
    overflow: visible;
}
.container{
    width: 80%;
    margin: 0 auto;
    padding: 0 10px;
}
.header .container {
    overflow: visible;
}
.logo{
    float: left;
    line-height: 38px;
    padding: 0 20px 0 45px;
    font-size: 18px;
    background: url(../assets/logo.gif) no-repeat scroll 0px 10px transparent;
    color: #666;
    text-decoration: none;
}
.nav{
    float: left;
}
.nav li {
    float: left;
    display: block;
    padding: 0;
    margin: 0;
    text-decoration: none;
}
.nav-item{
    display: block;
    line-height: 38px;
    padding: 0 14px 0 14px;
    margin: 0 1px 0 1px;
    text-decoration: none;
}
.nav-item{
    color: #333;
    background-color: transparent;
}
.is-active{
    background-color: #E5E5E5;
    box-shadow: 0 1px 5px rgba(0, 0, 0, 0.125) inset;
    color: #555555;
}
</style>
