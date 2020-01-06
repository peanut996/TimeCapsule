<template>
<div class="admin">
    <h2>Admin {{ $route.params.id }}</h2>
    <router-view></router-view>
</div>
</template>

<script>
export default {
  name: 'admin',
  components: {}
}
</script>
