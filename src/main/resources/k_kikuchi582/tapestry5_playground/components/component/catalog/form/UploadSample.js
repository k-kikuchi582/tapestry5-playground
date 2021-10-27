class UploadSample {
    constructor() {
        document.querySelector("#file-upload input[type=file]")
            .addEventListener("change", e => {
                const file = e.currentTarget.files[0];

                document.querySelector("#file-upload .file-name").textContent = file?.name;
            });
    }
}