<template>
<userheader></userheader>
<div>
    This is a User-Put Page.
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
body div{
  margin-top: 50px;
}
</style>
