interface IBtnUpload {
  label: string;
}
export const BtnUpload = ({ label }: IBtnUpload) => {
  return (
    <div>
      <p className="text-2xl font-medium mb-2">{label}</p>
      <button className="bg-gray-200 border-0 text-black btn btn-md p-4 w-full rounded-lg shadow-md text-2xl h-auto hover:bg-gray-300 font-medium ">
        Subir foto
      </button>
    </div>
  );
};
