<template>
  <div>
    <h1 class="mb-0">Hesap Oluştur</h1>
    <p>İnönü Üniversitesi emailiniz ile kendinize bir hesap oluşturabilirsiniz.</p>
    <form class="mt-4">
      <div class="form-group">
        <label for="exampleInputEmail1">Ad</label>
        <input type="email" class="form-control mb-0"  placeholder="Ad">
      </div>
          <div class="form-group">
        <label for="exampleInputEmail1">Soyad</label>
        <input type="email" class="form-control mb-0"  placeholder="Soyad">
      </div>
      <div class="form-group">
        <label for="exampleInputEmail2">İnönü Üniversitesi Email Adresi </label>
        <input type="email" class="form-control mb-0"  placeholder="Email">
      </div>
      <div class="form-group">
        <label for="exampleInputPassword1">Parola</label>
        <input type="password" class="form-control mb-0" placeholder="Parola">
      </div>
          <div class="form-group">
        <label for="exampleInputPassword1">Parola Tekrarı</label>
        <input type="password" class="form-control mb-0"  placeholder="Parola Tekrarı">
      </div>
      <div class="form-group">
        <div class="row">
      <div class="form-check col-6">
      <input class="form-check-input" type="checkbox" value="tmpGender" id="flexCheckDefault">
      <label class="form-check-label" for="flexCheckDefault">
        Erkek
      </label>
    </div>
    <div class="form-check col-6">
      <input class="form-check-input" type="checkbox" value="tmpGender" id="flexCheckChecked" checked>
      <label class="form-check-label" for="flexCheckChecked">
        Kadın
      </label>
    </div>
    </div>
    </div>
      <div class="d-inline-block w-100">
        <div class="custom-control custom-checkbox d-inline-block mt-2 pt-1">
          <input type="checkbox" class="custom-control-input" id="customCheck1">
          <label class="custom-control-label" for="customCheck1"><a href="#">Şartları ve koşulları</a> kabul ediyorum.</label>
        </div>
        <button type="submit" class="btn btn-primary float-right" @click="$router.push({name: 'social.list'})">Hesap Oluştur</button>
      </div>
      <div class="sign-info">
        <span class="dark-color d-inline-block line-height-2">Already Have Account ? <router-link :to="{ name: 'auth1.sign-in1'}">Log In</router-link></span>
      </div>
    </form>
  </div>
</template>
<script>

export default {
  name: 'SignUp1',
  data: () => ({}),
  methods: {
  }
}
</script>
