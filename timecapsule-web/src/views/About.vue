<template>
  <div class="about">
    <h1>全局变量</h1>
    <h2>  loginstate : {{ loginstate }}</h2>
    <h2> registerstate ： {{ registerstate }}</h2>
    <div>
      <button class="button" @click="change">change</button>
    </div>
  </div>
</template>
<script>
export default {
  methods: {
    change: function () {
      this.$store.commit('login')
    }
  },
  computed: {
    loginstate: function () {
      return this.$store.state.islogin
    },
    registerstate: function () {
      return this.$store.state.isregister
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
