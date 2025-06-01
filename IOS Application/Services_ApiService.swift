import Alamofire

class ApiService {
    static let shared = ApiService()
    private init() {}

    func fetchHukamnama(completion: @escaping (Hukamnama?) -> Void) {
        AF.request("https://www.hukamnamasahib.com/api/hukamnama").responseDecodable(of: Hukamnama.self) { response in
            completion(response.value)
        }
    }
}
