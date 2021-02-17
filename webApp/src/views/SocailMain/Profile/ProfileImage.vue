<template>
      <b-row class="row">
        <b-col v-for="(item,index) in profileImages" :key="index" md="6" lg="3" class="mb-3">
          <div class="user-images position-relative overflow-hidden">
            <a href="#">
              <img :src="item.img" class="img-fluid rounded" alt="Responsive image">
            </a>
            <div class="image-hover-data">
              <div class="product-elements-icon">
                <ul class="d-flex align-items-center m-0 p-0 list-inline">
                  <li v-for="(item,index1) in item.otherInfo" :key="index1">
                    <a href="#" class="pr-3 text-white"> {{item.value}} <i :class="item.class"></i> </a>
                  </li>
                </ul>
              </div>
            </div>
            <a href="#" class="image-edit-btn" data-toggle="tooltip" data-placement="top" title="" data-original-title="Edit or Remove"><i class="ri-edit-2-fill"></i></a>
          </div>
        </b-col>

      </b-row>
</template>
<script>
import { socialvue } from '../../../config/pluginInit'
export default {
  name: 'ProfileImage',
  mounted () {
    socialvue.index()
  },
  data () {
    return {
      profileImages: [
        {
          img: require('../../../assets/images/page-img/51.jpg'),
          otherInfo: [
            {
              class: 'ri-thumb-up-line',
              value: 10
            },
            {
              class: 'ri-chat-3-line',
              value: 2

            },
            {
              class: 'ri-share-forward-line',
              value: 1
            }
          ]
        },
        {
          img: require('../../../assets/images/page-img/52.jpg'),
          otherInfo: [
            {
              class: 'ri-thumb-up-line',
              value: 10
            },
            {
              class: 'ri-chat-3-line',
              value: 2

            },
            {
              class: 'ri-share-forward-line',
              value: 1
            }
          ]
        },
        {
          img: require('../../../assets/images/page-img/53.jpg'),
          otherInfo: [
            {
              class: 'ri-thumb-up-line',
              value: 120
            },
            {
              class: 'ri-chat-3-line',
              value: 21

            },
            {
              class: 'ri-share-forward-line',
              value: 10
            }
          ]
        },
        {
          img: require('../../../assets/images/page-img/54.jpg'),
          otherInfo: [
            {
              class: 'ri-thumb-up-line',
              value: 100
            },
            {
              class: 'ri-chat-3-line',
              value: 20

            },
            {
              class: 'ri-share-forward-line',
              value: 120
            }
          ]
        },
        {
          img: require('../../../assets/images/page-img/55.jpg'),
          otherInfo: [
            {
              class: 'ri-thumb-up-line',
              value: 107
            },
            {
              class: 'ri-chat-3-line',
              value: 20

            },
            {
              class: 'ri-share-forward-line',
              value: 101
            }
          ]
        },
        {
          img: require('../../../assets/images/page-img/56.jpg'),
          otherInfo: [
            {
              class: 'ri-thumb-up-line',
              value: 105
            },
            {
              class: 'ri-chat-3-line',
              value: 25

            },
            {
              class: 'ri-share-forward-line',
              value: 15
            }
          ]
        },
        {
          img: require('../../../assets/images/page-img/57.jpg'),
          otherInfo: [
            {
              class: 'ri-thumb-up-line',
              value: 107
            },
            {
              class: 'ri-chat-3-line',
              value: 27

            },
            {
              class: 'ri-share-forward-line',
              value: 17
            }
          ]
        },
        {
          img: require('../../../assets/images/page-img/58.jpg'),
          otherInfo: [
            {
              class: 'ri-thumb-up-line',
              value: 106
            },
            {
              class: 'ri-chat-3-line',
              value: 26

            },
            {
              class: 'ri-share-forward-line',
              value: 14
            }
          ]
        },
        {
          img: require('../../../assets/images/page-img/59.jpg'),
          otherInfo: [
            {
              class: 'ri-thumb-up-line',
              value: 10
            },
            {
              class: 'ri-chat-3-line',
              value: 24

            },
            {
              class: 'ri-share-forward-line',
              value: 14
            }
          ]
        },
        {
          img: require('../../../assets/images/page-img/60.jpg'),
          otherInfo: [
            {
              class: 'ri-thumb-up-line',
              value: 10
            },
            {
              class: 'ri-chat-3-line',
              value: 24

            },
            {
              class: 'ri-share-forward-line',
              value: 1
            }
          ]
        }
      ]
    }
  }
}
</script>
