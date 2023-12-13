<script setup lang="ts">
import { ref } from 'vue'
import { Button, ChoiceInput, Spinner, Toast, Toasts, Card, Divider } from "agnostic-vue";
import { doNothingForFiveSeconds } from '../services/doNothingService';

const isLoading = ref(false)
const formIsDisabled = ref(false)
const timedSuccessToast = ref(false)

/**
 * Disables form inputs and shows a spinner for five seconds. Then re-enables the inputs.
 */
const onClickSubmit = async () => {
  isLoading.value = true;
  formIsDisabled.value = true;
  await doNothingForFiveSeconds();
  isLoading.value = false;
  formIsDisabled.value = false;
  // alert('Submission Success!');
  timedSuccessToast.value = true;
  setTimeout(() => {
    timedSuccessToast.value = false;
  }, 5000);
};
</script>

<template>
  <!--Registration Form Card-->
  <Card is-stacked is-shadow class="p10">
    <div class="p20">
      <h1>Registration Form</h1>
    </div>
    <Divider size="small"></Divider>

    <div v-if="isLoading" class="loading">
      <Spinner />
    </div>

    <!--Cat Multi-Choice Form-->
    <div class="p10">
      <ChoiceInput id="r1" :is-disabled="formIsDisabled" type="radio" legend-label="What is your favorite kind of cat?"
        :options="[{
          name: 'solo',
          value: 'siamese',
          label: 'Siamese'
        }, {
          name: 'solo',
          value: 'persian',
          label: 'Persian'
        }, {
          name: 'solo',
          value: 'bengal',
          label: 'Bengal'
        }, {
          name: 'solo',
          value: 'other',
          label: 'Other'
        },]" />
    </div>

    <!--Submission Button-->
    <Divider size="small">
      <template #dividerContent>
        <Button @click="onClickSubmit()" :is-disabled="formIsDisabled">
          Submit
        </Button>
      </template>
    </Divider>
  </Card>

  <!--Success Toast-->
  <Toasts vertical-position="bottom" horizontal-position="center">
    <Toast :is-open="timedSuccessToast" type="success">
      <div class="flex-fill">
        Submission success!
      </div>
    </Toast>
  </Toasts>
</template>

<style>
.loading {
  position: absolute;
  top: 62%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 10;
  --agnostic-spinner-color: var(--agnostic-primary-modedark);
}
</style>