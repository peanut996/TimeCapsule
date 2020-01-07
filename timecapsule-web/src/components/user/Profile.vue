<template>
  <div>
    <userheader></userheader>
    <div class="user-profile-main">
      <div class="sidebar">
        <img class="big-img" src="../../assets/tide_logo.png" alt="" >
        <div></div>
        <div class="title">
          <p>
            <span class="title-nickname">{{ nickname }}</span>
            <span class="title-username">{{ '@' + username }}</span>
          </p>
        </div>
        <div class="sidebar-edit">
          <button class="edit-button" >Edit Profile</button>
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
      nickname: 'Peanuts',
      username: 'peanut996'
    }
  }
}
</script>

<style scoped>
.user-profile-main{
  margin-top: 40px;
  height: 800px;
}
.sidebar{
  display: block;
  background-color: white;
  width: 260px;
  height: 530px;
  margin-left: 10%;
  margin-top: 5%;
  /* border: 1px black solid; */
  box-shadow: 1px 1px 12px 1px gray;
}
.big-img{
  width: 260px;
  height: 260px;
  /* background-color: black; */
  margin: 0px;
  border: 0px 0px 0px 0px grey solid;
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
  /* background-color: brown; */
}
.edit-button{
  font-size: 14px;
  width: 258px;
  height: 40px;
  margin: 0px 1px 0px 1px;
  background-image: linear-gradient(-180deg,#fafbfc,#eff3f6 90%);
  border: 1px solid rgba(27,31,35,.2);
  border-radius: .25em;
}
</style>
