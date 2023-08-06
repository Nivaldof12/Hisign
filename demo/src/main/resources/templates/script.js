// File Upload Function
function uploadFile() {
    const fileInput = document.getElementById("fileInput");
    const file = fileInput.files[0];

    if (!file) {
        alert("Please select a file to upload.");
        return;
    }

    const formData = new FormData();
    formData.append("file", file);

    fetch("http://localhost:8080/teste/123/uploadpdf", {
        method: "POST",
        body: formData
    })
        .then(response => {
            if (response.ok) {
                alert("File uploaded successfully!");
            } else {
                alert("File upload failed!");
            }
        })
        .catch(error => {
            console.error("Error uploading file:", error);
            alert("File upload failed!");
        });
}

// File Download Function
function downloadPDF() {
    fetch("http://localhost:8080/teste/123/downloadpdf")
        .then(response => {
            if (!response.ok) {
                alert("File download failed!");
                return;
            }
            return response.blob();
        })
        .then(blob => {
            const url = URL.createObjectURL(blob);
            const a = document.createElement("a");
            a.href = url;
            a.download = "downloaded_file.pdf";
            a.click();
            URL.revokeObjectURL(url);
        })
        .catch(error => {
            console.error("Error downloading file:", error);
            alert("File download failed!");
        });
}
