<template>
  <div class="home">
    <img class="home-img" alt="Vue logo" src="../assets/logo.png" width="300px" height="150px" >
    <p class="title">时间胶囊控制台<p>
    <div class="home-button">
    <el-button class="button-left" size="medium" type="primary" @click="user" round>User</el-button>
    <div class="div-space"></div>
    <el-button class="button-right" size="medium" type="primary" @click="admin" round>Admin</el-button>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src

// import Admin from './Admin.vue'
// import User from './User.vue'

export default {
  name: 'home',
  components: {
  },
  methods: {
    user: function () {
      this.$router.push('/user')
    },
    admin: function () {
      // this.$router.push('/admin')
      window.location.href = 'https://api.godv2ray.online/swagger-ui.html'
    }
  }
}
</script>

<style>
.title{
  margin: 40px 0px 60px;
  font-size: 20px;
}
.div-space{
  display: inline-block;
  margin: 0px 40px 0px;
  width:50px;
}
.home-img{
  margin: 150px 0px 25px 0px;
}
.home{
text-align: center;
border-block-color: red;
height: 400px;
font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
}

</style>
