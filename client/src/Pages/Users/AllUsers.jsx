import React, { useEffect, useState } from 'react';
import { GET, PUT } from '../../helpers/httpHelper';
import { toast } from 'react-toastify';

function AllUsers() {
	const [users, setUsers] = useState([]); // [
	const getUserAll = async () => {
		try {
			const response = await GET('user/users');
			setUsers(response);
			console.log(response);
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
		getUserAll();
	}, []);

	const hadleActive = async (email) => {
		try {
			const response = await PUT('user/update-user?email=' + email);
			getUserAll();
			toast.success("User's status updated successfully!", {
				position: 'top-right',
				autoClose: 1950,
				hideProgressBar: false,
				closeOnClick: true,
				pauseOnHover: true,
				draggable: true,
				progress: undefined,
				theme: 'light',
			});
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

	return (
		<div
			style={{
				backgroundImage: `url(${process.env.PUBLIC_URL}/assets/svg-wave-generator.gif)`,
			}}
			className="w-[100%] min-h-screen bg-cover bg-center flex flex-col justify-center items-center"
		>
			<div className="m-10 bg-white px-5 py-10 shadow-xl rounded-md">
				<div className="text-center text-3xl font-extrabold text-gray-900">All Users</div>
				<div className="sm:container">
					<div className="overflow-auto block w-[300px] sm:w-full">
						<table className="w-full text-center border-collapse border border-slate-500  bg-white overflow-hidden">
							<thead className="bg-gray-400 text-md">
								<tr className="h-10">
									<th className="border px-4 py-2">Name</th>
									<th className="border px-4 py-2">Email</th>
									<th className="border px-4 py-2">Address</th>
									<th className="border px-4 py-2">Birthday</th>
									<th className="border px-4 py-2">User Type</th>
									<th className="border px-4 py-2">Active</th>
								</tr>
							</thead>
							<tbody>
								{users?.map((user, index) => (
									<tr
										key={index}
										className={`text-left h-10 ${
											index % 2 === 0 ? '' : 'bg-gray-200'
										} hover:bg-gray-300 cursor-pointer`}
									>
										<td className="border px-4 py-2">{user?.name ? user?.name : 'N/A'}</td>
										<td className="border px-4 py-2">{user?.email ? user?.email : 'N/A'}</td>
										<td className="border px-4 py-2">{user?.address ? user?.address : 'N/A'}</td>
										<td className="border px-4 py-2">{user?.dob ? user?.dob : 'N/A'}</td>
										<td className="border px-4 py-2">{user.type ? user.type : 'N/A'}</td>
										<td
											className={`border px-4 py-2 font-bold ${
												user.active ? 'text-green-500' : 'text-red-500'
											}`}
										>
											<button
												onClick={() => hadleActive(user.email)}
												disabled={localStorage.getItem('userEmail') === user.email}
												className={`${
													user.active ? 'bg-green-500' : 'bg-red-500'
												} hover:bg-green-700 text-white font-bold py-2 px-4 rounded disabled:opacity-50 disabled:cursor-not-allowed`}
											>
												{user.active ? 'Active' : 'Inactive'}
											</button>
										</td>
									</tr>
								))}
							</tbody>
						</table>
					</div>
				</div>
				{/* </div> */}
			</div>
		</div>
	);
}

export default AllUsers;
