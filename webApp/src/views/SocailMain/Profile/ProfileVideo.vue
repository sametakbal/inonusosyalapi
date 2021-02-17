<template>
    <b-row class="row">
      <b-col md="6" lg="4" class="mb-3" v-for="(item,index) in videoData" :key="index">
        <div class="user-images position-relative overflow-hidden">
          <div class="embed-responsive embed-responsive-16by9">
            <iframe class="embed-responsive-item" :src="item.img" allowfullscreen></iframe>
          </div>
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
  name: 'ProfileVideo',
  mounted () {
    socialvue.index()
  },
  data () {
    return {
      videoData: [
        {
          img: 'https://www.youtube.com/embed/K3M-czGNUCg',
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
          img: 'https://www.youtube.com/embed/Ml4XCF-JS0k',
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
          img: 'https://www.youtube.com/embed/pILFK2HfJtw',
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
          img: 'https://www.youtube.com/embed/FZ-_76rKlVU',
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
          img: 'https://www.youtube.com/embed/Ua5ilz9Vvrs',
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
          img: 'https://www.youtube.com/embed/JAIvWg4iQHo',
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
          img: 'https://www.youtube.com/embed/CMN--AT39-c',
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
          img: 'https://www.youtube.com/embed/CSB1EfostkQ',
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
          img: 'https://www.youtube.com/embed/eTZUoCVhlwk',
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
          img: 'https://www.youtube.com/embed/aU84KeezYMc',
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
        },
        {
          img: 'https://www.youtube.com/embed/s2bL_UpyYv0',
          otherInfo: [
            {
              class: 'ri-thumb-up-line',
              value: 104
            },
            {
              class: 'ri-chat-3-line',
              value: 2

            },
            {
              class: 'ri-share-forward-line',
              value: 14
            }
          ]
        },
        {
          img: 'https://www.youtube.com/embed/SlDifKHIJ1w',
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
        }
      ]
    }
  }
}
</script>
