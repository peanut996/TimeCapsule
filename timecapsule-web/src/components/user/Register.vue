<template>
<div>
    <userheader></userheader>
    <div class="user-register-main">
        <div class="container">
            <h1 class="page-header">注册</h1>
            <div class="main">
              <label class="form-label" ><span style="color:red;">* </span>用户名</label>
              <input class="form-input" required="required" type="text" v-model="user.username" >
              <label class="form-label" ><span style="color:red;">* </span>密码</label>
              <input class="form-input" required="required" type="password" v-model="user.password" >
              <label class="form-label" >昵称</label>
              <input class="form-input" type="text" v-model="user.nickname" >
              <label class="form-label" >邮箱</label>
              <input class="form-input" type="text" v-model="user.email" >
              <label class="form-label" >头像</label>
              <input class="form-file"  type="file" accept="image/png,image/gif,image/jpeg" @change="update"/>
              <p>
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
  name: 'register',
  components: { userheader },
  data: function () {
    return {
      user: {
        username: '',
        password: '',
        nickname: '',
        email: '',
        avatar: ''
      }
    }
  },
  methods: {
    update: function (file) {
      // smms图床处理
      // axios.get('',file).then((response)=>this.$message.success(response.data))
      this.$message.success('获取图床地址成功')
    },
    register: function () {
      this.$parent.isregister = true
      this.$router.push('/user-login')
    }
  }

}
</script>

<style scoped>
.user-register-main{
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
.form-file{
  margin-bottom: 1px;
}

input[type="file"]:hover,input[type="button"]:hover, input[type="submit"]:hover, button:hover, .btn:hover {
    background: #cc0033;
    border: 1px solid #cc0033;
    filter: none;
    color: #fff;
}
input[type="file"],input[type="button"], input[type="submit"], button, .btn, .pagination a {
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
