"use client";
import  InputModal  from "../list/InputModal";

interface ListModalProps {
  modalId: string;
  title: string;
  buttonText: string;
  closeButtonText: string;
}

function ListModal({
  modalId,
  title,
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
        <div className="modal-box w-1/4 max-w-5xl bg-orange-200">
          <h3 className="font-extrabold text-3xl text-center">{title}</h3>
          <div className="modal-action flex flex-row-reverse">
            <form method="dialog w-full">
              <div className="flex flex-col m-4 ">
                <InputModal />
              </div>
              <div>
                <button className="btn">{closeButtonText}</button>
              </div>
            </form>
          </div>
        </div>
      </dialog>
    </>
  );
}

export default ListModal;
