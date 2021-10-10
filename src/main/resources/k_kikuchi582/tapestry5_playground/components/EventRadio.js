const EventRadio = {
     init: (radioId, linkId) => {
         document.getElementById(radioId).addEventListener('change', () => {
              document.getElementById(linkId).click();
         });
     },
}