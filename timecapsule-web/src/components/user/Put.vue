<template>
<div>
  <userheader></userheader>
  <div class="user-put-main">
    This is a User-Put Page.
  </div>
</div>
</template>

<script>
import userheader from '../Header.vue'
export default {
  name: 'user-put',
  components: { userheader }
}
</script>

<style scoped>
body{
  margin: 0px;
}
.user-put-main{
  margin-top: 50px;
}
</style>
