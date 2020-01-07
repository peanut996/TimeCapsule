<template>
<div>
  <userheader></userheader>
  <div class="user-open-main">
        <div class="container">
          <h1 class="page-header">打开胶囊</h1>
          <div class="main">
            <label>胶囊Key:   </label>
            <input class="form-uuid" type="text" >
            <input class="form-submit" type="submit" @click="opencapsule" value="添加胶囊">
            <div>
              <textarea v-if="isget"  class="content"   cols="50" rows="8"></textarea>
            <div>
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
  name: 'open',
  components: { userheader },
  data: function () {
    return {
      isget: false,
      capsule: {
        content: '',
        opentime: ''
      },
      uuid: ''
    }
  },
  methods: {
    opencapsule: function () {
      // 根据uuid取出capsule 然后显示内容
      alert('请处理axios业务逻辑')
    }
  }
}
</script>

<style scoped>
.user-open-main{
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
.form-uuid{
  height: 24px;
  width: 260px;
}
.form-submit{
  margin-left: 10px;
  padding: 8px;
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
.tips{
  margin-top: 30px;
  display: block;
  font-size: 16px;
  padding: 0;
  margin: 0;
}
.content{
  float: left;
  margin-bottom: 0px;
  margin-top: 50px;
  border-radius:4px;
  border:1px solid #c8cccf;
  color:#6a6f77;
}
</style>
