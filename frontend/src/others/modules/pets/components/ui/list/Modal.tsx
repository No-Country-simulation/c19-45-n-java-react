"use client";

interface ListModalProps {
  modalId: string;
  title: string;
  content: string;
  buttonText: string;
  closeButtonText: string;
}

function ListModal({
  modalId,
  title,
  content,
  buttonText,
  closeButtonText,
}: ListModalProps) {
  const openModal = () => {
    const modal = document.getElementById(modalId) as HTMLDialogElement;
    if (modal) {
      modal.showModal();
    }
  };

  return (
    <>
      <button className="btn w-28 bg-orange-300" onClick={openModal}>
        {buttonText}
      </button>
      <dialog id={modalId} className="modal">
        <div className="modal-box w-11/12 max-w-5xl">
          <h3 className="font-bold text-lg">{title}</h3>
          <p className="py-4">{content}</p>
          <div className="modal-action">
            <form method="dialog">
              <button className="btn">{closeButtonText}</button>
            </form>
          </div>
        </div>
      </dialog>
    </>
  );
}

export default ListModal;
