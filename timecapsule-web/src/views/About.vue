<template>
  <div class="about">
    <h1>全局变量</h1>
    <h2>  loginstate : {{ loginstate }}</h2>
    <h2> registerstate ： {{ registerstate }}</h2>
    <h2> username ： {{ username }}</h2>
    <h2> uuid ： {{ getuuid }}</h2>
    <div>
      <button @click='get_history' width="40px" height="40px" value='获取历史记录'></button>
    </div>
  </div>
</template>
<script>
export default {
  data: function () {
    return {
      auuid: ''
    }
  },
  inject: ['reload'],
  methods: {
    get_history: function () {
      this.axios.get('https://bird.ioliu.cn/v2?url=https://sm.ms/api/v2/history?format=json')
        .then(response => { console.log(response) })
    },
    change: function () {
      window.location.reload()
    }
  },
  computed: {
    loginstate: function () {
      return this.$store.state.islogin
    },
    registerstate: function () {
      return this.$store.state.isregister
    },
    username: function () {
      return this.$store.state.username
    }
  }
}
</script>

<style scoped>
.about{
  text-align: center;
}
.button{
  width: 100px;
  height: 20px;
}
</style>
