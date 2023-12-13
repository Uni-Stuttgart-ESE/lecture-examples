<script setup lang="ts">
import { ref } from 'vue'
import { Button, ChoiceInput, Spinner, Card, Toast, Toasts } from "agnostic-vue";
import { doNothingForFiveSeconds } from '../services/doNothingService';

const isLoading = ref(false)

/**
 * Disables form inputs and shows a spinner for five seconds. Then re-enables the inputs.
 */
const onClickSubmit = async () => {
  isLoading.value = true;
  await doNothingForFiveSeconds();
  isLoading.value = false;
  alert('Submission Success!');
};
</script>

<template>
  <h1>Registration Form</h1>
  <div v-if="isLoading" class="loading">
    Loading...
  </div>

  <!--Cat Multi-Choice Form-->
  <fieldset>
    <legend>What is your favorite kind of cat?</legend>

    <div>
      <input type="radio" id="siamese" name="catType" value="siamese">
      <label for="siamese">Siamese</label>
    </div>

    <div>
      <input type="radio" id="persian" name="catType" value="persian">
      <label for="persian">Persian</label>
    </div>

    <div>
      <input type="radio" id="bengal" name="catType" value="bengal">
      <label for="bengal">Bengal</label>
    </div>

    <div>
      <input type="radio" id="other" name="catType" value="other">
      <label for="other">Other</label>
    </div>

  </fieldset>


  <!--Submission Button-->
  <button @click="onClickSubmit()">
    Submit
  </button>
</template>

<style>
.loading {
  position: absolute;
  bottom: 0%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 10;
}
</style>