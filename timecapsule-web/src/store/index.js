import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    // 默认为未登录 已注册状态
    islogin: false,
    // 全局默认已经注册
    isregister: true
  },
  mutations: {
    login (state) {
      state.islogin = true
    },
    register (state) {
      state.isregister = !state.isregister
    }
  },
  actions: {
  },
  modules: {
  }
})
