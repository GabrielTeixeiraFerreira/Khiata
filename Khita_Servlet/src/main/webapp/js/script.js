document.addEventListener("DOMContentLoaded", function () {
    // Função genérica para configurar o evento de exibição e fechamento de pop-ups
    function configurarPopup(containerClass, popupId, closePopupId) {
        const popup = document.getElementById(popupId);
        const closePopupBtn = document.getElementById(closePopupId);
        const body = document.body;

        // Mostra o pop-up ao clicar no card
        document
            .querySelector(containerClass)
            .addEventListener("click", function () {
                popup.style.display = "block";
                body.style.overflow = "hidden"; // Evita que o scroll seja permitido na página
            });

        // Fecha o pop-up ao clicar no botão de fechar
        closePopupBtn.addEventListener("click", function () {
            popup.style.display = "none";
            body.style.overflow = "auto"; // Retorna o scroll à página original
        });
    }

    // Configurar pop-ups para cada pessoa
    configurarPopup(".mais1", "popup1", "closePopup1");
    configurarPopup(".mais2", "popup2", "closePopup2");
    configurarPopup(".mais3", "popup3", "closePopup3");
    configurarPopup(".mais4", "popup4", "closePopup4");
    configurarPopup(".mais5", "popup5", "closePopup5");
    configurarPopup(".mais6", "popup6", "closePopup6");
    configurarPopup(".mais7", "popup7", "closePopup7");
    configurarPopup(".mais8", "popup8", "closePopup8");
    configurarPopup(".mais9", "popup9", "closePopup9");
    configurarPopup(".mais10", "popup10", "closePopup10");
    configurarPopup(".mais11", "popup11", "closePopup11");
});

// PARTE PARA ACIONAR HAMBURGUER
function toggleMenu() {
    const navLinks = document.querySelector(".nav-links");
    navLinks.classList.toggle("active");
}
  