<template>
<div>
    <userheader></userheader>
    <div class="user-login-main">
        <div class="container">
            <h1 class="page-header">登录</h1>
            <div class="main">
                <label class="form-label">用户名</label>
                <input class="form-input" type="text" v-model="username" >
                <label class="form-label">密码</label>
                <input class="form-input" type="password">
                <p>
                    <input type="submit" @click="login" class="form-submit" value="登录">
                    <input type="submit" @click="register" class="form-submit" value="注册">
                </p>
            </div>
        </div>
    </div>
</div>
</template>

<script>
import userheader from '../Header.vue'
export default {
  name: 'login',
  components: { userheader },
  data: function () {
    return {
      username: '',
      password: ''
    }
  },
  methods: {
    login: function () {
      this.$parent.islogin = true
      this.$message.success('登录成功!')
      this.$router.push('/user-profile')
    },
    register: function () {
      this.$parent.isregister = false
      this.$message.success('前往注册页面...')
      this.$router.push('/user-register')
    }
  }
}
</script>

<style scoped>
.user-login-main{
    margin-top: 50px;
}
.container{
  width: 960px;
  margin: 0 auto;
  padding: 0 10px;
}
.page-header{
    font-size: 28px;
    border-bottom: 0 solid #9CF;
    padding: 0 0 7px 0;
    margin-top: 30px;
    margin-bottom: 10px;
    color: #555;
    line-height: 28px;
    float: left;
}
.main{
  width: 980px;
  float: left;
  padding-bottom: 60px;
}
.form-label{
  display: block;
  margin-top: 20px;
  margin-bottom: 5px;
}
.form-input{
  -webkit-appearance:none;
  -moz-appearance: none;
  font-size: 16px;
  height: 26px;
  border-radius:4px;
  border:1px solid #c8cccf;
  color:#6a6f77;
  outline:0;
  margin-bottom: 18px;
}
.form-submit{
  margin: 20px 50px 0px 0px;
  width: 60px;
}

input[type="button"]:hover, input[type="submit"]:hover, button:hover, .btn:hover {
    background: #cc0033;
    border: 1px solid #cc0033;
    filter: none;
    color: #fff;
}
input[type="button"], input[type="submit"], button, .btn, .pagination a {
    display: inline-block;
    padding: 7px 12px;
    background-color: #39E;
    background: -moz-linear-gradient(#39E,#2389de);
    background: -webkit-linear-gradient(#39E,#2389de);
    border: 1px solid #39E;
    color: #fff;
    -moz-border-radius: 2px;
    -webkit-border-radius: 2px;
    border-radius: 2px;
}
.form-input:focus{
  border:1px solid #db4e72;
}
</style>
