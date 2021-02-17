<template>
  <div class="iq-comingsoon pt-5">
    <div class="container-fluid">
      <div class="row justify-content-center">
        <div class="col-sm-9 text-center">
          <div class="iq-comingsoon-info">
            <a href="#">
              <img :src="require('../../assets/images/logo.png')" class="img-fluid w-25" alt="logo">
            </a>
            <h2 class="mt-4 mb-1">Stay tunned, we're launching very soon</h2>
            <p>We are working very hard to give you the best experience possible!</p>
            <ul class="countdown" countdown data-date="Feb 02 2022 20:20:22">
              <li><span data-days>658</span>Days</li>
              <li><span data-hours>9</span>Hours</li>
              <li><span data-minutes>43</span>Minutes</li>
              <li><span data-seconds>15</span>Seconds</li>
            </ul>
          </div>
        </div>
      </div>
      <div class="row justify-content-center">
        <div class="col-lg-4">
          <form class="iq-comingsoon-form mt-5">
            <div class="form-group">
              <input type="email" class="form-control mb-0" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email address">
            </div>
            <button type="submit" class="btn btn-primary">Subscribe</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { socialvue } from '../../config/pluginInit'

export default {
  name: 'ComingSoon',
  mounted () {
    socialvue.index()
  }
}
</script>
