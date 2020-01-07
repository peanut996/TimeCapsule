<template>
<div>
  <userheader></userheader>
  <div class="user-put-main">
    <div class="container">
          <h1 class="page-header">添加胶囊</h1>
          <div class="main">
            <div class="form">
              <label class="form-label">你的名字</label>
              <input class="form-input" v-model="capsule.nickname"  >
              <label class="form-label">你的邮箱</label>
              <input class="form-input" v-model="capsule.email" >
              <label class="form-label">打开时间</label>
              <input class="form-input" v-model="capsule.opentime" >
              <span class="tips">打开时间之前你是看不见的。</span>
              <label class="form-label">胶囊内容</label>
              <textarea class="form-text" rows="8" cols="50" v-model="capsule.content"></textarea>
              <span class="tips">胶囊内容不能超过5000字。</span>
              <label class="form-label">未到期警告信息</label>
              <textarea class="form-text" rows="3" cols="50" v-model="capsule.warningcontent"></textarea>
              <span class="tips">在 打开时间 之前打开胶囊，会看到提示信息。</span>
              <p>
                <input class="form-submit" type="submit" @click="submitcapsule" value="添加胶囊">
              </p>
            </div>
          </div>
    </div>

  </div>
</div>
</template>

<script>
import userheader from '../Header.vue'
export default {
  name: 'user-put',
  components: { userheader },
  data: function () {
    return {
      // 验证是否登录
      // isregister: true,
      islogin: false,
      capsule: {
        content: '',
        username: '',
        nickname: '',
        email: '',
        opentime: '',
        uuid: '',
        warningcontent: ''
      }
    }
  },
  methods: {
    submitcapsule: function () {
      // 加入验证逻辑和判断
      /* post
       */
      alert('test here!')
    }
  }
}
</script>

<style scoped>
body{
  margin: 0px;
  text-align: left;
}
.user-put-main{
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
  margin-bottom: 18px;
  outline:0;
}
.form-input:focus{
  border:1px solid #db4e72;
}
.form-text:focus{
  border:1px solid #db4e72;
}
.tips{
    font-size: 12px;
    padding: 0;
    margin: 0;
    color: #999;
    background-color: #f6f6f6;
}
.form-text{
  margin-bottom: 0px;
  border-radius:4px;
  border:1px solid #c8cccf;
  color:#6a6f77;
}
.form-submit{
  margin-top: 20px;
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
</style>
