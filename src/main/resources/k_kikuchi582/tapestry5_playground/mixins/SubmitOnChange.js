const SubmitOnChange = {
     init: (fieldId, submitId) => {
         document.getElementById(fieldId).addEventListener('change', () => {
              document.getElementById(submitId).click();
         });
     },
}