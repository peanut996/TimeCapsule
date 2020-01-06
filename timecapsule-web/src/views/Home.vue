<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png" width="100px" height="50px" >
    <p>时间胶囊<p>
    <div class="home-button">
    <el-button size="medium" type="primary" @click="user" round>User</el-button>
    <el-button  size="medium" type="primary" @click="admin" round>Admin</el-button>
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
      this.$router.push('/admin')
    }
  }
}
</script>

<style>
.home{
font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
}
.home-button{
  position: absolute;
  padding : 0px 0px 0px 0px;
  margin: 40px;

}

</style>
