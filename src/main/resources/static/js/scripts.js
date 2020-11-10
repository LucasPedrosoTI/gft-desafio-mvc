$("#confirmacaoExclusaoModal").on("show.bs.modal", function (event) {
  const button = $(event.relatedTarget);

  const id = button.data("id");
  const nome = button.data("nome");

  const modal = $(this);
  const form = modal.find("form");

  let action = location.pathname;

  if (action.endsWith("/")) {
    action = action.substr(0, action.lastIndexOf("/"));
  }

  form.attr("action", `${action}/${id}`);

  modal
    .find(".modal-body span")
    .html("Tem certeza que deseja excluir <strong>" + nome + "</strong>?");
});

$(function () {
  $('[rel="tooltip"]').tooltip();
});
