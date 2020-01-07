<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>
<script>

export default {
  name: 'app',
  components: {
  },
  data: function () {
    return {
      islogin: false
    }
  }
}
</script>

<style>
#app {
  font-family: 'Microsoft YaHei UI','Microsoft YaHei','微软雅黑',"MicrosoftJhengHei", '华文细黑', STHeiti, MingLiu,serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}
body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, code, form, fieldset, legend, input, textarea, p, blockquote, th, td {
    margin: 0;
    padding: 0;
}
ul, ol { list-style: none; }
a{ text-decoration: none;}
</style>
