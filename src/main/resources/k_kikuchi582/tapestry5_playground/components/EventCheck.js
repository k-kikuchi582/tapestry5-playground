const EventCheck = {
     init: (checkboxId, linkId) => {
         document.getElementById(checkboxId).addEventListener('change', () => {
              document.getElementById(linkId).click();
         });
     },
}