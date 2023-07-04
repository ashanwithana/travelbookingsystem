import React, { useEffect, useState } from 'react';
import { GET } from '../../helpers/httpHelper';

function Profile() {
	const [name, setName] = useState('');
	const [email, setEmail] = useState('');
	const [address, setAddress] = useState('');
	const [dob, setDob] = useState('');
	const [type, setType] = useState('ADMIN');

	const getUser = async () => {
		try {
			const response = await GET('user/get-user?email=' + localStorage.getItem('userEmail'));
			setName(response?.name);
			setEmail(response?.email);
			setAddress(response?.address);
			setDob(response?.dob);
			setType(response?.type);
		} catch (error) {
			console.log(error);
			toast.error(`${error?.response?.data || error?.message}`, {
				position: 'top-right',
				autoClose: 1950,
				hideProgressBar: false,
				closeOnClick: true,
				pauseOnHover: true,
				draggable: true,
				progress: undefined,
				theme: 'light',
			});
		}
	};

	useEffect(() => {
		getUser();
	}, []);

	return (
		<div
			style={{
				backgroundImage: `url(${process.env.PUBLIC_URL}/assets/svg-wave-generator.gif)`,
			}}
			className="w-[100%] min-h-screen bg-cover bg-center flex flex-col justify-center items-center"
		>
			<div className="flex flex-col items-center bg-white w-full sm:w-[400px] px-5 py-10 gap-10 shadow-xl rounded-md my-10">
				<div className=" flex items-center justify-center font-bold text-2xl">My Profile</div>
				<input
					className="bg-[#ddFFFD] p-2 pl-10 w-full hover:bg-[#ddFFFD] rounded-md"
					placeholder="Name"
					type="text"
					value={name}
					onChange={(e) => setName(e.target.value)}
					disabled
				/>
				<input
					className="bg-[#ddFFFD] p-2 pl-10 w-full hover:bg-[#ddFFFD] rounded-md disabled:bg-[#ddFFFD]"
					placeholder="Email"
					type="text"
					value={email}
					onChange={(e) => setEmail(e.target.value)}
					disabled
				/>
				<textarea
					className="bg-[#ddFFFD] p-2 pl-10 w-full hover:bg-[#ddFFFD] rounded-md disabled:bg-[#ddFFFD]"
					placeholder="Address"
					type="text"
					value={address}
					onChange={(e) => setAddress(e.target.value)}
					disabled
				/>
				<input
					className="bg-[#ddFFFD] p-2 pl-10 w-full hover:bg-[#ddFFFD] rounded-md disabled:bg-[#ddFFFD]"
					placeholder="Birthday"
					type="date"
					value={dob}
					onChange={(e) => setDob(e.target.value)}
					disabled
				/>
				<input
					className="bg-[#ddFFFD] p-2 pl-10 w-full hover:bg-[#ddFFFD] rounded-md disabled:bg-[#ddFFFD]"
					placeholder="type"
					type="text"
					value={type}
					onChange={(e) => setType(e.target.value)}
					disabled
				/>
			</div>
		</div>
	);
}

export default Profile;
