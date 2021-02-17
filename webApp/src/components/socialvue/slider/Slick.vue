<template>
  <vue-slick :options="option">
    <slot />
  </vue-slick>
</template>
<script>
import VueSlick from 'vue-slick'
export default {
  name: 'Slick',
  components: {
    VueSlick
  },
  props: {
    option: { type: Object,
      default: () => {
        return {
          slidesToShow: 6,
          slidesToScroll: 1,
          focusOnSelect: true,
          arrows: false,
          responsive: [{
            breakpoint: 992,
            settings: {
              arrows: false,
              centerMode: true,
              slidesToShow: 3
            }
          }, {
            breakpoint: 480,
            settings: {
              arrows: false,
              centerMode: true,
              slidesToShow: 1
            }
          }],
          nextArrow: '<a href="#" class="ri-arrow-left-s-line left"></a>',
          prevArrow: '<a href="#" class="ri-arrow-right-s-line right"></a>'
        }
      }
    }
  },
  data () {
    return {
    }
  }
}
</script>
