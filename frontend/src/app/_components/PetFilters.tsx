import { IoFilter } from "react-icons/io5";

export const PetFilters = () => {
  return (
    <div className="flex justify-between">
      <h2 className="text-4xl font-bold">Especies</h2>
      <button className="btn btn-active text-white btn-lg shadow-lg">
        <IoFilter size={32} />
      </button>
    </div>
  );
};
