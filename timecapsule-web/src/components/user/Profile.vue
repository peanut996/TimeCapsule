<template>
  <div>
    <userheader></userheader>
    <div class="user-profile-main">
      <div class="sidebar">
        <img class="big-img" src="../../assets/github-logo-128px.png" alt="" >
        <div></div>
        <div class="title">
            <span class="title-nickname">{{ nickname }}</span>
            <span class="title-username">{{ '@' + username }}</span>
        </div>
        <div class="sidebar-edit">
          <button class="edit-button" @click="logout" >Log Out</button>
        </div>
      </div>
      <div class="user-profile-body">
        <div class='body-navbar' >
          <span class="body-navbar-title">Overview</span>
        </div>
        <div class='body-content'>
          <div class="body-content-left">
            <div  class="content-item">
              <span class="form-span">昵称</span>
              <span class="content-span">{{ nickname }}</span>
            </div>
            <div  class="content-item">
              <span class="form-span">邮箱</span>
              <span class="content-span">{{ email }}</span>
            </div>
            <!-- <div class="content-item"></div> -->
          </div>
          <div class="body-content-right">
            <div  class="content-item">
              <span class="form-span">用户名</span>
              <span class="content-span">{{ username }}</span>
            </div>
            <div  class="content-item">
              <span class="form-span">描述</span>
              <span class="content-span">{{ description }}</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import userheader from '../Header.vue'
export default {
  name: 'profile',
  components: { userheader },
  data: function () {
    return {
      avatar: '',
      nickname: '',
      username: '',
      email: '',
      description: 'Nothing Special Here. '
    }
  },
  methods: {
    logout: function () {
      this.$store.commit('login')
      this.$store.commit('getusername', '')
      this.$router.push('/user-login')
      this.$message.success('注销成功')
    }
  },
  created: function () {
    this.axios.get('http://localhost:8080/user/' + this.$store.state.username).then(response => {
      this.username = response.data.username
      this.nickname = response.data.nickname
      this.email = response.data.email
      this.avatar = response.data.avatar
    })
      .catch(error => {
        if (error.response) {
          console.log(error.response.data)
          console.log(error.response.status)
          console.log(error.response.headers)
        } else if (error.request) {
          console.log(error.request)
        } else {
          console.log('Error', error.message)
        }
        console.log(error.config)
      })
  }
}
</script>

<style scoped>
.user-profile-main{
  width: 100%;
  margin-top: 40px;
  /* background-color: aquamarine; */
}
.sidebar{
  float: left;
  display: block;
  background-color: white;
  width: 260px;
  height: 500px;
  margin-left: 12%;
  margin-top: 5%;
  /* border: 1px black solid; */
  box-shadow: 1px 1px 12px 1px rgb(172, 172, 172);
}
.big-img{
  width: 260px;
  height: 260px;
  /* background-color: black; */
  margin: 0px;
  border: 0px 0px 0px 0px grey solid;
}
.title{
  /* background-color: red; */
  margin: 30px 20px 50px;
  font-size: 20px;
}
.title-nickname{
  display: block;
  font-size: 28px;
  margin-bottom: 10px;
  margin-left: 10px;

}
.title-username{
  display: block;
  font-size: 14px;
  margin-left: 10px;
}
.sidebar-edit{
  width: 260px;
  height: 40px;
}
.edit-button{
  font-size: 14px;
  width: 230px;
  height: 40px;
  margin: 0px 15px 0px ;
  background-image: linear-gradient(-180deg,#fafbfc,#eff3f6 90%);
  border: 1px solid rgba(27,31,35,.2);
  border-radius: .25em;
}
.edit-button:hover{
    background: #cc0033;
    border: 1px solid #cc0033;
    filter: none;
    color: #fff;
}
.user-profile-body{
  float: left;
  /* background-color: chocolate; */
  width: 800px;
  height: 500px;
  margin-top: 5%;
  margin-left: 5%;
  box-shadow: 1px 1px 12px 1px rgb(190, 190, 190);
}
.body-navbar{
  /* background-color: darksalmon; */
  width: 800px;
  height: 125px;
  /* border: 1px black dashed;
  border-bottom-style: none; */
  box-shadow: 1px 1px 12px 1px rgb(190, 190, 190);
}
.body-navbar-title{
  font-size: 64px;
  font-weight: bolder;
  display: inline-block;
  width: 100%;
  height: 100px;
  text-align: center;
  padding: 12.5px 0px;
  font-family: arial,sans-serif;
  line-height: 100px;
}
.body-content{
  /* background-color: aquamarine; */
  width: 100%;
  height: 375px;
}
.body-content-left{
  float: left;
  height: 100%;
  width: 50%;
  /* background-color: cornflowerblue; */
}
.body-content-right{
  float: left;
  height: 100%;
  width: 50%;
  /* background-color: royalblue; */
}
.content-item{
  width: 100%;
  height: 187.5px;
  background-image: linear-gradient(-180deg,#fafbfc,#eff3f6 90%);
}
.form-span{
  display: block;
  font-size: 36px;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  font-style: italic;/*斜体*/
  font-weight: bold;/*加粗*/
  /* background-color: coral; */
  height: 60px;
  padding: 52px 0px 0px 70px;
}
.content-span{
  display: block;
  font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
  font-size: 24px;/*设置字体的大小*/
  font-weight: bold;/*加粗*/
  /* background-color: greenyellow; */
  height: 76px;
  padding-top: 5px;
  padding-left: 70px;
}
</style>
