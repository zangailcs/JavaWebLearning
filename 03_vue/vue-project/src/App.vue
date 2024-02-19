<template>
  <div>
    <!-- <h1>{{message}}</h1> -->
    <ElementView></ElementView>
  </div>
</template>

<script>
import ElementView from './views/element/ElementView.vue'
export default {
  components: {ElementView},
  data() {
    return {
      message: "Hello vue"
    }
  }
}
</script>


<style>

</style>
