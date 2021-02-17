<template>
  <iq-card body-class="p-0">
    <template v-slot:body>
      <div class="user-post-data p-3">
        <div class="d-flex flex-wrap">
          <div class="media-support-user-img mr-3">
            <b-img rounded="circle" fluid :src="post.user.profile" alt=""/>
          </div>
          <div class="media-support-info mt-2">
            <h5 class="mb-0"><b-link href="javascript:void(0)" class="">{{post.user.name}}</b-link></h5>
            <p class="mb-0 text-secondary">{{post.time | formatDate }}</p>
          </div>
          <div class="iq-card-header-toolbar d-flex align-items-center">
            <b-dropdown id="dropdownMenuButton40" right variant="none" menu-class="p-0">
              <template v-slot:button-content>
                <b-link href="javascript:void(0)" class="text-secondary"><i class="ml-3 ri-more-2-line"></i></b-link>
              </template>
              <a class="dropdown-item p-3" href="javascript:void(0)" @click="isFollowed(!post.is_follow)">
                <div class="d-flex align-items-top">
                  <div class="icon font-size-20"><i class="ri-user-unfollow-line"></i></div>
                  <div class="data ml-2">
                    <span v-if="post.is_follow">
                      <h6>  Unfollow User</h6>
                    </span>
                    <span v-else>
                      <h6>  Follow User</h6>
                    </span>
                    <p class="mb-0">Stop seeing posts but stay friends.</p>
                  </div>
                </div>
              </a>
              <a href="javascript:void(0)" class="dropdown-item p-3">
                <div class="d-flex align-items-top">
                  <div class="icon font-size-20"><i class="ri-save-line"></i></div>
                  <div class="data ml-2">
                    <h6>Save Post</h6>
                    <p class="mb-0">Add this to your saved items</p>
                  </div>
                </div>
              </a>
              <a href="javascript:void(0)" class="dropdown-item p-3">
                <div class="d-flex align-items-top">
                  <div class="icon font-size-20"><i class="ri-close-circle-line"></i></div>
                  <div class="data ml-2">
                    <h6>Hide Post</h6>
                    <p class="mb-0">See fewer posts like this.</p>
                  </div>
                </div>
              </a>
              <a class="dropdown-item p-3" href="javascript:void(0)">
                <div class="d-flex align-items-top">
                  <div class="icon font-size-20"><i class="ri-notification-line"></i></div>
                  <div class="data ml-2">
                    <h6>Notifications</h6>
                    <p class="mb-0">Turn on notifications for this post</p>
                  </div>
                </div>
              </a>
            </b-dropdown>
          </div>
        </div>
      </div>
    </template>
    <hr class="m-0" />
    <div class="user-post">
      <p class="p-2" v-if="post.description">{{post.description}}</p>
      <div id="photo-grid">
        <photo-grid :box-height="'400px'" :box-width="'100%'" :boxBorder=2>
          <img v-for="(image, index) in post.images" :src="image" :key="index" />
        </photo-grid>
      </div>
    </div>
    <div class="comment-area p-3">
      <div class="d-flex justify-content-between align-items-center">
        <div class="d-flex align-items-center justify-content-between">
          <div class="like-block position-relative d-flex align-items-center">
            <div class="d-flex align-items-center">
              <div class="like-data">
                <div class="dropdown">
                  <span class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" role="button">
                    <img :src="require('../../../../assets/images/icon/01.png')" class="img-fluid" alt="">
                  </span>
                  <div class="dropdown-menu" style="">
                    <a class="ml-2 mr-2" href="javascript:void(0)" data-toggle="tooltip" data-placement="top" @click="isLiked(!post.is_liked)" title="" data-original-title="Like"><img :src="require('../../../../assets/images/icon/01.png')" class="img-fluid" alt=""></a>
                    <a class="mr-2" href="javascript:void(0)" data-toggle="tooltip" data-placement="top" @click="isLiked(!post.is_liked)" title="" data-original-title="Love"><img :src="require('../../../../assets/images/icon/02.png')" class="img-fluid" alt=""></a>
                    <a class="mr-2" href="javascript:void(0)" data-toggle="tooltip" data-placement="top" @click="isLiked(!post.is_liked)" title="" data-original-title="Happy"><img :src="require('../../../../assets/images/icon/03.png')" class="img-fluid" alt=""></a>
                    <a class="mr-2" href="javascript:void(0)" data-toggle="tooltip" data-placement="top" @click="isLiked(!post.is_liked)" title="" data-original-title="HaHa"><img :src="require('../../../../assets/images/icon/04.png')" class="img-fluid" alt=""></a>
                    <a class="mr-2" href="javascript:void(0)" data-toggle="tooltip" data-placement="top" @click="isLiked(!post.is_liked)" title="" data-original-title="Think"><img :src="require('../../../../assets/images/icon/05.png')" class="img-fluid" alt=""></a>
                    <a class="mr-2" href="javascript:void(0)" data-toggle="tooltip" data-placement="top" @click="isLiked(!post.is_liked)" title="" data-original-title="Sade"><img :src="require('../../../../assets/images/icon/06.png')" class="img-fluid" alt=""></a>
                    <a class="mr-2" href="javascript:void(0)" data-toggle="tooltip" data-placement="top" @click="isLiked(!post.is_liked)" title="" data-original-title="Lovely"><img :src="require('../../../../assets/images/icon/07.png')" class="img-fluid" alt=""></a>
                  </div>
                </div>
              </div>
              <div class="total-like-block ml-2 mr-3">
                <div class="dropdown">
                <span class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" role="button">
                {{post.likes}} Likes
                </span>
                  <div class="dropdown-menu">
                    <a class="dropdown-item" href="javascript:void(0)">Max Emum</a>
                    <a class="dropdown-item" href="javascript:void(0)">Bill Yerds</a>
                    <a class="dropdown-item" href="javascript:void(0)">Hap E. Birthday</a>
                    <a class="dropdown-item" href="javascript:void(0)">Tara Misu</a>
                    <a class="dropdown-item" href="javascript:void(0)">Midge Itz</a>
                    <a class="dropdown-item" href="javascript:void(0)">Sal Vidge</a>
                    <a class="dropdown-item" href="javascript:void(0)">Other</a>
                  </div>
                </div>
              </div>
            </div>
            <div class="total-comment-block">
              <div class="dropdown">
               <span class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" role="button">
               {{post.comments.length}} Comment
               </span>
                <div class="dropdown-menu">
                  <a class="dropdown-item" href="javascript:void(0)">Max Emum</a>
                  <a class="dropdown-item" href="javascript:void(0)">Bill Yerds</a>
                  <a class="dropdown-item" href="javascript:void(0)">Hap E. Birthday</a>
                  <a class="dropdown-item" href="javascript:void(0)">Tara Misu</a>
                  <a class="dropdown-item" href="javascript:void(0)">Midge Itz</a>
                  <a class="dropdown-item" href="javascript:void(0)">Sal Vidge</a>
                  <a class="dropdown-item" href="javascript:void(0)">Other</a>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="share-block d-flex align-items-center feather-icon mr-3">
          <a href="javascript:void(0)"><i class="ri-share-line"></i>
            <span class="ml-1">99 Share</span></a>
        </div>
      </div>
      <hr>
      <ul class="post-comments p-0 m-0">
        <li class="mb-2" v-for="(postComment, postCommentIndex) in post.comments" :key="postComment.id">
          <div class="d-flex flex-wrap">
            <div class="user-img">
              <b-img :src="postComment.image" alt="userimg" class="avatar-35"  rounded="circle" fluid />
            </div>
            <div class="comment-data-block ml-3">
              <h6>{{postComment.user.name}}</h6>
              <p class="mb-0">{{postComment.user.msg}}</p>
              <div class="d-flex flex-wrap align-items-center comment-activity">
                <b-link @click="isLikedComment(postCommentIndex, !postComment.is_commentLike)">
                  <span v-if="!postComment.is_commentLike" class="text-primary">like</span>
                  <span class="text-secondary" v-else>unlike</span>
                </b-link>
                <b-link href="javascript:void(0);">reply</b-link>
                <span>{{postComment.user.time | formatDate}}</span>
              </div>
            </div>
          </div>
        </li>
      </ul>
      <b-form class="comment-text d-flex align-items-center mt-3" action="javascript:void(0);">
        <b-form-input type="text" @keyup.enter="saveComment(commentMessage)" v-model="commentMessage" class="rounded" placeholder="Lovely!" />
        <div class="comment-attagement d-flex">
          <b-link href="javascript:void(0);"><i class="ri-send-plane-line mr-2" @click="saveComment(commentMessage)"></i></b-link>
        </div>
      </b-form>
    </div>
</iq-card>
</template>
<script>
export default {
  name: 'SocialPost',
  props: [
    'post'
  ],
  data () {
    return {
      commentMessage: ''
    }
  },
  methods: {
    isLiked (postLike) {
      this.post.is_liked = postLike

      if (postLike) {
        this.post.likes += 1
      } else {
        this.post.likes -= 1
      }
    },
    isFollowed (follow) {
      this.post.is_follow = follow
    },
    isLikedComment (index, like) {
      this.post.comments[index].is_commentLike = like
    },
    saveComment (postComment) {
      this.post.comments.push({
        image: require('../../../../assets/images/user/user-04.jpg'),
        user: { name: 'Sandy S', msg: postComment, time: new Date() },
        is_commentLike: false
      })

      this.commentMessage = ''
    }
  }
}
</script>

<style>
  .dropdown-item{
    color: #212529 !important;
  }
  .dropdown-menu .dropdown-item:focus, .dropdown-menu .dropdown-item:hover{
    background: transparent;
    color: var(--iq-primary) !important;
  }
</style>
