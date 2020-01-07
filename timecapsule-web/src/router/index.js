import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Admin from '../views/Admin.vue'
import User from '../views/User.vue'
import Put from '../components/user/Put.vue'
import Open from '../components/user/Open.vue'
import Login from '../components/user/Login.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/user',
    name: 'user',
    component: User
  },
  {
    path: '/user-put',
    name: 'user-put',
    component: Put
  },
  {
    path: '/user-login',
    name: 'user-login',
    component: Login
  },
  {
    path: '/user-open',
    component: Open
  },
  {
    path: '/admin',
    component: Admin
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }
]

const router = new VueRouter({
  linkActiveClass: 'active',
  routes
})

export default router
