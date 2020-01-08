<template>
  <div class="about">
    <h1>全局变量</h1>
    <h2>  loginstate : {{ loginstate }}</h2>
    <h2> registerstate ： {{ registerstate }}</h2>
    <h2> username ： {{ username }}</h2>
    <h2> uuid ： {{ getuuid }}</h2>
    <div>
      <button class="button" @click="getuuid">change</button>
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
    uuid: function () {
      var s = []
      var hexDigits = '0123456789abcdef'
      for (var i = 0; i < 36; i++) {
        s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1)
      }
      s[14] = '4'
      s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1)
      s[8] = s[13] = s[18] = s[23] = '-'
      this.uuidA = s.join('')
      console.log(s.join(''), 's.join("")')
      return this.uuidA
    },
    change: function () {
      window.location.reload()
    }
  },
  computed: {
    getuuid: function () {
      return this.uuid()
    },
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
