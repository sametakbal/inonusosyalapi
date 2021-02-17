<template>
  <div class="iq-card">
    <div class="iq-card-body">
      <div class="row align-items-center">
        <div class="col-md-12 mb-3">
          <h5 class="text-primary float-left"><i class="ri-pencil-fill"></i> Compose Message</h5>
          <button type="submit" class="float-right close-popup" v-if="modal" @click="close" data-dismiss="modal"><i class="ri-close-fill"></i></button>
        </div>
      </div>
      <form class="email-form">
        <div class="form-group row">
          <label for="inputEmail3" class="col-sm-2 col-form-label">To:</label>
          <div class="col-sm-10">
            <select  id="inputEmail3" class="select2jsMultiSelect form-control" multiple="multiple">
              <option value="Petey Cruiser">Petey Cruiser</option>
              <option value="Bob Frapples">Bob Frapples</option>
              <option value="Barb Ackue">Barb Ackue</option>
              <option value="Greta Life">Greta Life</option>
            </select>
          </div>
        </div>
        <div class="form-group row">
          <label for="cc" class="col-sm-2 col-form-label">Cc:</label>
          <div class="col-sm-10">
            <select  id="cc" class="select2jsMultiSelect form-control" multiple="multiple">
              <option value="Brock Lee">Brock Lee</option>
              <option value="Rick O'Shea">Rick O'Shea</option>
              <option value="Cliff Hanger">Cliff Hanger</option>
              <option value="Barb Dwyer">Barb Dwyer</option>
            </select>
          </div>
        </div>
        <div class="form-group row">
          <label for="subject" class="col-sm-2 col-form-label">Subject:</label>
          <div class="col-sm-10">
            <input type="text"  id="subject" class="form-control">
          </div>
        </div>
        <div class="form-group row">
          <label for="subject" class="col-sm-2 col-form-label">Your Message:</label>
          <div class="col-md-10">
            <textarea class="textarea form-control" rows="5">Next, use our Get Started docs to setup Tiny!</textarea>
          </div>
        </div>
        <div class="form-group row align-items-center pt-3 m-0">
          <div class="d-flex flex-grow-1 align-items-center">
            <div class="send-btn">
              <button type="submit" class="btn btn-primary">Send</button>
            </div>
            <div class="send-panel">
              <label class="ml-2 mb-0 iq-bg-primary rounded" for="file"> <input type="file" id="file" style="display: none"> <a><i class="ri-attachment-line"></i> </a> </label>
              <label class="ml-2 mb-0 iq-bg-primary rounded"> <a href="javascript:void(0)"> <i class="ri-map-pin-user-line text-primary"></i></a>  </label>
              <label class="ml-2 mb-0 iq-bg-primary rounded"> <a href="javascript:void(0)"> <i class="ri-drive-line text-primary"></i></a>  </label>
              <label class="ml-2 mb-0 iq-bg-primary rounded"> <a href="javascript:void(0)"> <i class="ri-camera-line text-primary"></i></a>  </label>
              <label class="ml-2 mb-0 iq-bg-primary rounded"> <a href="javascript:void(0)"> <i class="ri-user-smile-line text-primary"></i></a>  </label>
            </div>
          </div>
          <div class="d-flex align-items-center">
            <div class="send-panel float-right">
              <label class="ml-2 mb-0 iq-bg-primary rounded" ><a href="javascript:void(0)"><i class="ri-settings-2-line text-primary"></i></a></label>
              <label class="ml-2 mb-0 iq-bg-primary rounded"><a href="javascript:void(0)">  <i class="ri-delete-bin-line text-primary"></i></a>  </label>
            </div>
          </div>
        </div>
      </form>
    </div>
  </div>
</template>
<script>
export default {
  name: 'ComposeBody',
  props: {
    modal: { type: Boolean, default: false }
  },
  methods: {
    close () {
      this.$emit('close', false)
    }
  }
}
</script>
